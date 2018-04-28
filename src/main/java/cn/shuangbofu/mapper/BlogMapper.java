package cn.shuangbofu.mapper;

import cn.shuangbofu.entity.Blog;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericfu on 2018/3/20.
 */
@Mapper
public interface BlogMapper {

    List<Blog> findList(@Param("ids") String... ids);

    List<Blog> findTitleListByIds(@Param("ids") String... ids);

    List<Blog> findListByCategory(@Param("categoryId") Integer categoryId);

    Blog findOne(@Param("id") Integer id);

//    Blog getTitle(@Param("id") Integer id);

    Blog getNext(@Param("id") Integer id);

    Blog getLast(@Param("id") Integer id);

    Integer save(Blog newBlog);
//    List<Blog> findHotList();
    List<Blog> getHotIds();

//    List<Blog> getSpecialIds();
}