package com.dxm.dxmbe.enums;

public interface ErrorException {
    public static String ERROR_SERVER = "Vui lòng liên hệ với Dxmer để được hỗ trợ!";
    public static String USERNAME_EXIST = "Tên đăng nhập đã tồn tại";
    public static String PHONE_EXIST = "Số điện thoại đã được sử dụng";
    public static String EMAIL_EXIST = "Email đã được sử dụng";
    public static String USER_NOT_EXIST = "Tài khoản không tồn tại";
    public static String USERNAME_PASSWORD_WRONG = "Tài khoản hoặc mật khẩu không chính xác! ";
    public static String INVALID_JWT_TOKEN = "Bạn cần đăng nhập! ";
    public static String EXPIRED_JWT_TOKEN = "Hết hạn đăng nhập! ";

}
