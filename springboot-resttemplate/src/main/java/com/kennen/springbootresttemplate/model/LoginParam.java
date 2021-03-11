package com.kennen.springbootresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录认证接口参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginParam {
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** Application ID */
    private String appid;
    /** IMEI码 */
    private String imei;
}
