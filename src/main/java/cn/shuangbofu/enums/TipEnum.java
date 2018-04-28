package cn.shuangbofu.enums;

import lombok.Getter;

/**
 * Created by ericfu on 2018/4/4.
 */
@Getter
public enum TipEnum {

    TAG_TIP("tag/", "标签"),
    CATEGORY_TIP("category/", "分类"),
    NONE_TIP("articles/", "");

    private String path;

    private String title;

    TipEnum(String path, String title) {
        this.path = path;
        this.title = title;
    }
}
