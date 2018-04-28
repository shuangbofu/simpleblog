package cn.shuangbofu.mapper;

import cn.shuangbofu.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by ericfu on 2018/3/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void findOne() throws Exception {
//        Category category = categoryMapper.findOne("tech");
//        Assert.assertNotNull(category.getCategoryName());
    }

}