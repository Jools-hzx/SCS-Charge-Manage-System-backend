package com.joolshe.chargesys.bean;

/**
 * @author Zexi He.
 * @date 2023/5/14 14:06
 * @description: 返回消息的 bean
 */
public class Result<T> {

    private String code;
    private String msg;

    private T data;

    //该方法返回成功结果
    public static Result<Object> success(String msg) {
        Result<Object> res = new Result<>();
        res.setCode("200");
        res.setMsg(msg);
        return res;
    }

    //该方法返回成功结果并携带数据
    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    //该方法返回错误消息,不携带数据
    public static Result<Object> error(String type, String msg) {
        Result<Object> result = new Result<>();
        result.setCode(getErrorCode(type));
        result.setMsg(msg);
        return result;
    }

    //该方法返回错误消息，携带数据
    public static <T> Result<T> error(String type, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(getErrorCode(type));
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    //该方法返回服务端错误消息，携带数据
    public static String getErrorCode(String type) {
        switch (type) {
            case "client":
                return "4xx";
            case "server":
                return "5xx";
            default:
                return "undefined";
        }
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
