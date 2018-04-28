package cn.shuangbofu.vo;

import lombok.Data;

/**
 * Created by ericfu on 2018/3/28.
 */
@Data
public class ResultVO<T> {
    private Integer code;

    private String msg = "";

    private T data;
}
