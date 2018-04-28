package cn.shuangbofu.exception;

import cn.shuangbofu.enums.ResultEnum;

/**
 * Created by ericfu on 2018/3/13.
 */
public class SiteException extends RuntimeException {

    private Integer code;

    public SiteException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SiteException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
