package com.wang.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    private int code;//值
    private String msg;//结果

    private Map<String, Object> extend = new HashMap<>();//储存返回的结果

    public static R success() {
        R result = new R();
        result.setCode(100);
        result.setMsg("success");
        return result;
    }
    public static R fail() {
        R result = new R();
        result.setCode(200);
        result.setMsg("error");
        return result;
    }

    public R add(String key,Object value) {
        this.getExtend().put(key, value);
        return this;
    }
}
