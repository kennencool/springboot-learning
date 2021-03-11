package com.kennen.springbootresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 解绑通知参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnbindParam {
    /** IMEI码 */
    private String imei;
    /** 网点 */
    private String location;
}
