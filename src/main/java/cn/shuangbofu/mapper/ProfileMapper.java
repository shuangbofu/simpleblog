package cn.shuangbofu.mapper;

import cn.shuangbofu.entity.Profile;
import cn.shuangbofu.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by ericfu on 2018/3/20.
 */
@Mapper
public interface ProfileMapper {
    Profile get();
}
