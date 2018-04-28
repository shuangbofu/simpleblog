package cn.shuangbofu.entity;

import lombok.Data;
import java.util.Date;

/**
 * Created by ericfu on 2018/3/11.
 */
@Data
public class Blog {

    private Integer id;

    private String title;

    private String summary;

    private String content;

    private String htmlContent;

    private Category category;

    private String tags;

    private int commentSize;

    private int readSize;

    private Boolean original;

    private String copyrightInfo;

    private Date createTime;

    private Date updateTime;

}
