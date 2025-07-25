package com.sia.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private T data; //数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        return success(object,null);
    }
    public static <T> Result<T> success(T object,String message) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        result.msg = message;
        return result;
    }

    public static <T> Result<T> error(String message) {
        Result result = new Result();
        result.msg = message;
        result.code = 0;
        return result;
    }

}
