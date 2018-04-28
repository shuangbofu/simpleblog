package cn.shuangbofu.mapper;

import cn.shuangbofu.entity.Tag;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ericfu on 2018/3/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagMapperTest {

    @Autowired
    private TagMapper tagMapper;

    @Test
    public void findAll() throws Exception {
//        List<Tag> tagList = tagMapper.findAllByCat("tech");
//        Assert.assertNotEquals(0, tagList.size());
    }

    @Test
    public void insertIfNotExistsTest() {
        String tags = "微信小程序, 入门, 基础";
//        tagMapper.insertIfNotExist(tags.split(", "), "tech");
//        Assert.assertNotEquals(0, result);
//        System.out.println(result);
    }

}