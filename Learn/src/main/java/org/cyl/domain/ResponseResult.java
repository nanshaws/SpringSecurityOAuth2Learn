package org.cyl.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult <T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult() {
        this.code = 200;
        this.msg = "ok";
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult failResult(String text) {
        ResponseResult result=new ResponseResult();
        result.code=400;
        result.msg=text;
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public static ResponseResult okResult(){
        ResponseResult result=new ResponseResult();
        return result;
    }
    public static ResponseResult okResult(String text){
        ResponseResult result=new ResponseResult();
        result.msg=text;
        return result;
    }
}
