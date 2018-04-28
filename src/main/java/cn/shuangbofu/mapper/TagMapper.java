package cn.shuangbofu.mapper;

import cn.shuangbofu.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by ericfu on 2018/3/20.
 */
@Mapper
public interface TagMapper {

    List<Tag> findList();
    Integer save(Tag tag);
    Integer increaseUsenum(Integer id);
}
