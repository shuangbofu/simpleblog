package cn.shuangbofu.service.impl;

import cn.shuangbofu.constant.RedisKeyConstant;
import cn.shuangbofu.entity.Category;
import cn.shuangbofu.entity.Tag;
import cn.shuangbofu.mapper.CategoryMapper;
import cn.shuangbofu.service.CategoryService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericfu on 2018/3/24.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Category> findList() {
        List<Category> categoryList = new ArrayList<>();
//        ValueOperations<String, String> ops =  stringRedisTemplate.opsForValue();
//        Gson gson = new Gson();
//        if(stringRedisTemplate.hasKey(RedisKeyConstant.CATEGORY_LIST_KEY)) {
//            String tagsJson = ops.get(RedisKeyConstant.CATEGORY_LIST_KEY);
//            categoryList = gson.fromJson(tagsJson, new TypeToken<List<Category>>(){}.getType());
//        } else {
            categoryList = categoryMapper.findList();
//            String value = gson.toJson(categoryList);
//            ops.set(RedisKeyConstant.CATEGORY_LIST_KEY, value);
//        }
        return categoryList;
    }

    @Override
    public Category findOne(Integer id) {
        return categoryMapper.findOne(id);
    }
}
