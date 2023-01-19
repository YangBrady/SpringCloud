package me.yangjun.study.springcloud.common.entitys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static CommonResult success(String message) {
        return new CommonResult(200, message);
    }

    public static CommonResult fail(String message) {
        return new CommonResult(500, message);
    }
}
