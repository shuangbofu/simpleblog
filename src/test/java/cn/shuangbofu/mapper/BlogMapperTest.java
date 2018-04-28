package cn.shuangbofu.mapper;

import cn.shuangbofu.entity.Blog;
import com.github.pagehelper.PageHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericfu on 2018/3/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogMapperTest {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void findAllTest() throws Exception{
        String ids = "1, 10, 14";
//        ids = "";
        List<Blog> blogs = blogMapper.findList(ids.split(","));
        blogs.forEach(blog -> {
            System.out.println(blog);
        });
        Assert.assertNotEquals(0, blogs.size());
    }



}