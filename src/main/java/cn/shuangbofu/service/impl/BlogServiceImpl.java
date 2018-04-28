package cn.shuangbofu.service.impl;

import cn.shuangbofu.constant.BlogConstant;
import cn.shuangbofu.constant.RedisKeyConstant;
import cn.shuangbofu.convert.Blog2BlogDetailConvert;
import cn.shuangbofu.dto.ArchiveBlog;
import cn.shuangbofu.dto.BlogDetail;
import cn.shuangbofu.dto.BlogForm;
import cn.shuangbofu.dto.CopyRight;
import cn.shuangbofu.entity.Blog;
import cn.shuangbofu.entity.Category;
import cn.shuangbofu.enums.ResultEnum;
import cn.shuangbofu.exception.SiteException;
import cn.shuangbofu.mapper.BlogMapper;
import cn.shuangbofu.mapper.CategoryMapper;
import cn.shuangbofu.mapper.TagMapper;
import cn.shuangbofu.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import sun.nio.cs.ext.MacDingbat;

import javax.jws.Oneway;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by ericfu on 2018/3/11.
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private  TagMapper tagMapper;

    private final String slat = "simpleblog";

    @Override
    public List<Blog> findAll(Integer categoryId, String tag, int pageNum, int pageSize) {
        String key = executeKey(tag);
        List<Blog> blogs = new ArrayList<>();
        String[] ids = null;
        PageHelper.startPage(pageNum, pageSize);
        if (categoryId!=0) {
          blogs = blogMapper.findListByCategory(categoryId);
        } else if(BlogConstant.DEFAULT_NULL_TAG.equals(tag) || stringRedisTemplate.hasKey(key)) {
            if (stringRedisTemplate.hasKey(key)) {
                ids = stringRedisTemplate.opsForValue().get(key).split(BlogConstant.DEFAULT_DELIMITER);
            }
            blogs = blogMapper.findList(ids);
        }
        PageHelper.clearPage();
        return blogs;
    }

    @Override
    public BlogDetail findOne(Integer id) {
        Blog blog = blogMapper.findOne(id);
        BlogDetail blogDetail = new BlogDetail();
        BeanUtils.copyProperties(blog, blogDetail);
        Gson gson = new Gson();
        CopyRight copyright = gson.fromJson(blog.getCopyrightInfo(), new TypeToken<CopyRight>(){}.getType());
        blogDetail.setCopyright(copyright);
        Blog last = blogMapper.getLast(id);
        Blog next = blogMapper.getNext(id);
       if (last!=null) {
           blogDetail.setLast(last);
       }
       if (next!=null) {
           blogDetail.setNext(next);
       }
        return blogDetail;
    }
    @Override
    public List<Blog> findHotList() {
        String[] ids = {};
        List<Blog> hotList = new ArrayList<>();
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(RedisKeyConstant.HOT_IDS_LIST_KEY)) {
            ids = ops.get(RedisKeyConstant.HOT_IDS_LIST_KEY).split(BlogConstant.DEFAULT_DELIMITER);
        } else {
            List<Blog> hotIdsList = blogMapper.getHotIds();
            StringBuffer sb = new StringBuffer("");
            hotIdsList.forEach(blog -> {
                sb.append(blog.getId());
                sb.append(BlogConstant.DEFAULT_DELIMITER);
            });
            String idsStr = sb.toString().substring(0, sb.length()-1);
            ids = idsStr.split(BlogConstant.DEFAULT_DELIMITER);
            ops.set(RedisKeyConstant.HOT_IDS_LIST_KEY, idsStr);
        }
        hotList = blogMapper.findTitleListByIds(ids);
        return hotList;
    }

    @Override
    public List<Blog> findSpecialList() {
        List<Blog> specialList = new ArrayList<>();
        String[] ids = stringRedisTemplate.opsForValue().get(RedisKeyConstant.SPECIAL_IDS_LIST_KEY).split(BlogConstant.DEFAULT_DELIMITER);
        if(ids.length > 0) {
            specialList = blogMapper.findTitleListByIds(ids);
        }
        return specialList;
    }

    @Override
    @Transactional
    public Blog saveBlog(BlogForm blogForm) {
        Blog newBlog = new Blog();
        Gson gson = new Gson();
        BeanUtils.copyProperties(blogForm, newBlog);
        CopyRight copyRight = new CopyRight(blogForm.getAuthor(), blogForm.getUrl(), blogForm.getPlatform());
        newBlog.setCopyrightInfo(gson.toJson(copyRight));
        blogMapper.save(newBlog);
        blogForm.getTagList().forEach(tag -> {
            if (tag.getId()!=null) {
                tagMapper.increaseUsenum(tag.getId());
                String ids = stringRedisTemplate.opsForValue().get(executeKey(tag.getName()));
                ids = ids + "," + newBlog.getId();
                stringRedisTemplate.opsForValue().set(executeKey(tag.getName()), ids);
            } else {
                tagMapper.save(tag);
                String key  = executeKey(tag.getName());
                stringRedisTemplate.opsForValue().set(key, newBlog.getId().toString());
            }
        });
        categoryMapper.increaseUsenum(blogForm.getCategory().getId());
        return newBlog;
    }

    private String executeKey(String tagName) {
        tagName = tagName + "/" + slat;
        return DigestUtils.md5DigestAsHex(tagName.getBytes());
    }
}
