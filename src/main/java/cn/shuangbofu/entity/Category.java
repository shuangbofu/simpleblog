package cn.shuangbofu.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by ericfu on 2018/3/11.
 */
@Data
public class Category {

    private Integer id;

    private String name;

    private Integer usenum;

    private Date createTime;

    private Date updateTime;
}
