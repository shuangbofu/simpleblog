package cn.shuangbofu.convert;

import cn.shuangbofu.dto.BlogDetail;
import cn.shuangbofu.entity.Blog;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

/**
 * Created by ericfu on 2018/3/20.
 */
public class Blog2BlogDetailConvert {

//    public static BlogDetail convert(Long blogId, List<Blog> blogList, String categoryName) {
//        System.out.println(blogList);
//        BlogDetail blog = new BlogDetail();
//        if (blogList.size() > 2) {
//            BeanUtils.copyProperties(blogList.get(1), blog);
//            blog.setNext(blogList.get(2));
//            blog.setLast(blogList.get(0));
//        } else if (blogList.size() == 1) {
//            BeanUtils.copyProperties(blogList.get(0), blog);
//        } else {
//            if (blogList.get(0).getBlogId().equals(blogId)) {
//                BeanUtils.copyProperties(blogList.get(0), blog);
//                blog.setNext(blogList.get(1));
//            } else {
//                BeanUtils.copyProperties(blogList.get(1), blog);
//                blog.setLast(blogList.get(0));
//            }
//        }
//        blog.setCategoryName(categoryName);
//        return blog;
//    }
}
