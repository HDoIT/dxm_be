package com.dxm.dxmbe.utils;
import com.dxm.dxmbe.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Component
public class Auth {

    @Value("${dxm-be.jwt.secret-key}")
    private String secretKey;

    @Value("${dxm-be.jwt.expiration}")
    private long expiration;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    public Boolean matchPassword(String password,String encodedPassword){
        return passwordEncoder.matches(password,encodedPassword);
    }

    public String generateToken(User user){
        try {
            return Jwts.builder()
                    .setSubject(user.getUserName())
                    .claim("id",user.getId())
                    .claim("password",user.getPassword())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expiration))
                    .signWith(SignatureAlgorithm.HS256, getSigningKey())
                    .compact();
        }catch (JwtException e){
            return null;
        }
    }

    public Boolean validateToken(String token){
        try {
            token = token.replace("Bearer ", "");
            Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(token);
            return true;
        }catch (ExpiredJwtException e){
            System.out.println("xxx "+e);
            throw new JwtException("Expired or invalid JWT token");
        }catch (JwtException e){
            System.out.println("yyy "+e);
            throw new JwtException("Invalid JWT token");
        }
//        return false;
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token) {
        token = token.replace("Bearer ", "");
        System.out.println("token: " + token);
        return getClaims(token).getSubject();
    }

//    public Long getIdFromToken(String token) {
//        return getClaims(token).get("id").toString();
//    }

    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

//    public boolean validateToken(String token) {
//        token = token.replace("Bearer ", "");
//        String tokenUsername = getUsernameFromToken(token);
//        return !isTokenExpired(token);
//    }

}
