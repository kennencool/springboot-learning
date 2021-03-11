package com.kennen.springbootresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Controller的基础返回类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    /** 是否成功 */
    private boolean success;
    /** 说明 */
    private String msg;
    /** 返回数据 */
    private T data;
}
