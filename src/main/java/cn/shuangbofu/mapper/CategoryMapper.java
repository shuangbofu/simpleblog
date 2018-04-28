package cn.shuangbofu.mapper;

import cn.shuangbofu.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by ericfu on 2018/3/20.
 */
@Mapper
public interface CategoryMapper {
    List<Category> findList();
    Category findOne(Integer id);
    Integer increaseUsenum(Integer id);
}
