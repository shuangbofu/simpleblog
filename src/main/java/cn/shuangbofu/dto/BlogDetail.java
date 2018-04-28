package cn.shuangbofu.dto;

import cn.shuangbofu.entity.Blog;
import cn.shuangbofu.entity.Category;
import lombok.Data;

import java.util.Date;

/**
 * Created by ericfu on 2018/3/12.
 */
@Data
public class BlogDetail {

    private Integer id;

    private String title;

    private String summary;

//    private String content;

    private String htmlContent;

    private Category category;

    private int commentSize;

    private int readSize;

    private Date createTime;

    private Date updateTime;

    private String tags;

    private Boolean original;

    private Blog last;

    private Blog next;

    private CopyRight copyright;

//    private List<Comment> comments;
}
