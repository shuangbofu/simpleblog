package cn.shuangbofu.dto;

import cn.shuangbofu.entity.Category;
import cn.shuangbofu.entity.Tag;
import lombok.Data;

import java.util.List;

/**
 * Created by ericfu on 2018/4/13.
 */
@Data
public class BlogForm {
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private String htmlContent;
    private Category category;
    private List<Tag> tagList;
    private String tags;
    private Boolean original;
    private String author;
    private String url;
    private String platform;
}
