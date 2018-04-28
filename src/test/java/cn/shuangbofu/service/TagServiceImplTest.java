package cn.shuangbofu.service;

import cn.shuangbofu.entity.Tag;
import cn.shuangbofu.service.impl.TagServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ericfu on 2018/3/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagServiceImplTest {

    @Autowired
    private TagServiceImpl tagService;

    @Test
    public void findAllByCatTtest() throws Exception {
//        List<Tag> tags = tagService.findAllByCat("tech");
//        for(Tag tag: tags) {
//            System.out.println(tag);
//        }
//        Assert.assertEquals(17, tags.size());
    }

    @Test
    public void findAllTagsTest() throws Exception {
//        List<Tag> tags = tagService.findAllTags();
//        System.out.println(tags.size());
//        Assert.assertEquals(25,  tags.size());
    }

}