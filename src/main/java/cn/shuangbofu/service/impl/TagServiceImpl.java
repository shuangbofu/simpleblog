package cn.shuangbofu.service.impl;

import cn.shuangbofu.constant.BlogConstant;
import cn.shuangbofu.constant.RedisKeyConstant;
import cn.shuangbofu.entity.Category;
import cn.shuangbofu.entity.Tag;
import cn.shuangbofu.mapper.BlogMapper;
import cn.shuangbofu.mapper.CategoryMapper;
import cn.shuangbofu.mapper.TagMapper;
import cn.shuangbofu.service.TagService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ericfu on 2018/3/12.
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Tag> findList() {
        List<Tag> tagList = new ArrayList<>();
//        Gson gson = new Gson();
//        if(stringRedisTemplate.hasKey(RedisKeyConstant.TAG_LIST_KEY)) {
//            String tagsJson = stringRedisTemplate.opsForValue().get(RedisKeyConstant.TAG_LIST_KEY);
//            tagList = gson.fromJson(tagsJson, new TypeToken<List<Tag>>(){}.getType());
//        } else {
            tagList = tagMapper.findList();
//            String value = gson.toJson(tagList);
//            stringRedisTemplate.opsForValue().set(RedisKeyConstant.TAG_LIST_KEY, value);
//        }
        return tagList;
    }
}
