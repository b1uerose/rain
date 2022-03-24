package org.xiao.rain.test.password;

import org.xiao.rain.exception.BusinessException;

/**
 * Author: xiaojl
 * Date: 2022/1/18 17:04
 */
public class PasswordDecode {

    //密钥
    private static final String AES_KEY = "bWFsbHB3ZA==WNST";

    public String descrptPasswordWhenAuth(String passwordSrc) {
        try {
            return AesUtil.aesDecrypt(passwordSrc);
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }

}
