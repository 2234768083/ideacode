package com.example.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private static final String CODE_SUCCESS = "200";
    private static final String CODE_ERROR = "-1";

    private String code;  // 200 成功  非200 失败
    private Object data;  // 返回给前端的数据
    private String msg;   // 消息内容，通常会包含本次接口请求失败的原因

    public static Result success() {
        Result result = new Result();
        result.setCode(CODE_SUCCESS);
        result.setMsg("成功");
        return result;
    }

    public static Result success(Object obj) {
        Result result = new Result();
        result.setCode(CODE_SUCCESS);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(CODE_ERROR);
        result.setMsg(msg);
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


}
