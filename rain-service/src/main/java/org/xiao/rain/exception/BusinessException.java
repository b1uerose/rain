package org.xiao.rain.exception;

/**
 * 异常
 * Author: xiaojl
 * Date: 2021/6/29 23:47
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = 2739828293991894328L;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
    
    public BusinessException(Exception e) {
        super(e);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
