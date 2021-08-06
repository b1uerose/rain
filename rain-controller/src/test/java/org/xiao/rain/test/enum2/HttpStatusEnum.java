package org.xiao.rain.test.enum2;

/**
 * 
 * Author: xiaojl
 * Date: 2021/6/29 21:02
 */
public enum HttpStatusEnum {
    
    SUCCESS(200, "成功"),
    FAILURE(404, "失败")
    ;
    
    private int statusCode;
    private String description;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private HttpStatusEnum(int statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public static void main(String[] args) {
        for (HttpStatusEnum value : HttpStatusEnum.values()) {
            System.out.println(value);
            System.out.println(value.getStatusCode());
            System.out.println(value.getDescription());
        }
    }
}
