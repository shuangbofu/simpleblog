package cn.shuangbofu.service;

import cn.shuangbofu.entity.Category;

import java.util.List;

/**
 * Created by ericfu on 2018/3/24.
 */
public interface CategoryService {

    List<Category> findList();

    Category findOne(Integer id);
}
