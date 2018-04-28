package cn.shuangbofu.service;

import cn.shuangbofu.dto.BlogDetail;
import cn.shuangbofu.entity.Blog;
import cn.shuangbofu.service.impl.BlogServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ericfu on 2018/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceImplTest {

    @Autowired
    private BlogServiceImpl blogService;


    @Test
    public void findAllTest() {
        String tag = "Java";
        tag = "Spring";
        tag = "";
        List<Blog> blogList = blogService.findAll(0, tag, 1, 10);
        blogList.forEach(blog -> {
            System.out.println(blog);
        });
        Assert.assertNotEquals(0, blogList.size());
    }

    @Test
    public void findOneTest() {
        BlogDetail blogDetail = blogService.findOne(1);
        System.out.println(blogDetail);
    }

}