package com.dxm.dxmbe.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResqBean<T> {

    private int status;
    private String msg;
    private T data;
    private int errorCode;


    public static ResqBean ok(String msg,Object data) {
        return new ResqBean(200,msg,data,0);
    }

    public static ResqBean error(String msg,Object data,int errorCode) {
        return new ResqBean(500,msg,data,errorCode);
    }

//    public T getData(){
//        return data;
//    }
//
//    public ResqBean setData(T data) {
//        this.data = data;
//        return this;
//    }

}
