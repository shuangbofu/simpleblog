package cn.shuangbofu.enums;

import lombok.Getter;

/**
 * Created by ericfu on 2018/3/13.
 */
@Getter
public enum  ResultEnum {
//    BLOG_PUBLISH_SUCCESS(200, "")
    BLOG_NOT_FOUND(404, "没有找到该文章"),

    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
