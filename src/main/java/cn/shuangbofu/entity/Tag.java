package cn.shuangbofu.entity;

import lombok.Data;
import java.util.Date;

/**
 * Created by ericfu on 2018/3/11.
 */
@Data
public class Tag {

    private Integer id;

    private String name;

    private int usenum;

    private Date createTime;

    private Date updateTime;

    public Tag(String name, int usenum) {
        this.name = name;
        this.usenum = usenum;
    }

    public Tag(){}
}
