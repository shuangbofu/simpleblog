package cn.shuangbofu.dto;

import lombok.Data;

/**
 * Created by ericfu on 2018/4/4.
 */
@Data
public class CopyRight {

    private String author;

    private String url;

    private String platform;

    public CopyRight(String author, String url, String platform) {
        this.author = author;
        this.url = url;
        this.platform = platform;
    }
}
