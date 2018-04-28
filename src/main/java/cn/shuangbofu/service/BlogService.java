package cn.shuangbofu.service;

import cn.shuangbofu.dto.ArchiveBlog;
import cn.shuangbofu.dto.BlogDetail;
import cn.shuangbofu.dto.BlogForm;
import cn.shuangbofu.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by ericfu on 2018/3/11.
 */
public interface BlogService {

    List<Blog> findAll(Integer categoryId, String tag, int pageNum, int pageSize);

    BlogDetail findOne(Integer id);

    List<Blog> findHotList();

    List<Blog> findSpecialList();

    Blog saveBlog(BlogForm blogForm);
}
