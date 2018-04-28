package cn.shuangbofu.controller;

import cn.shuangbofu.dto.BlogForm;
import cn.shuangbofu.entity.Blog;
import cn.shuangbofu.entity.Category;
import cn.shuangbofu.entity.Tag;
import cn.shuangbofu.service.BlogService;
import cn.shuangbofu.service.CategoryService;
import cn.shuangbofu.service.TagService;
import cn.shuangbofu.util.ResultVOUtil;
import cn.shuangbofu.vo.ResultVO;
import cn.shuangbofu.vo.Tip;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ericfu on 2018/3/27.
 */
@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @GetMapping("/publish")
    public String publishPage(Model model) {
        List<Category> categories = categoryService.findList();
        List<Tag> tags = tagService.findList();
        model.addAttribute("categories", categories);
        model.addAttribute("tags", tags);
        model.addAttribute("blog", new BlogForm());
        model.addAttribute("title", "发表新博客");
        return "/admin/edit";
    }

    @PostMapping("/save")
    public @ResponseBody
    ResultVO<String> saveBlog(@RequestBody BlogForm blogForm) {
        System.out.println(blogForm);
        Blog blog = blogService.saveBlog(blogForm);
        String redirectUrl = "";
        if (blog != null) {
            redirectUrl = "/blog/article/" + blog.getId();
        }
        return ResultVOUtil.success(redirectUrl);
    }

    @GetMapping("/list")
    public String list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
                       @RequestParam(value = "tag", required = false, defaultValue = "") String tag,
                       @RequestParam(value = "categoryId", required = false, defaultValue = "0") Integer categoryId,
                       Model model) {


//        List<Blog> blogs = blogService.findAll(categoryId, tag, pageNum, pageSize);
//        PageInfo<Blog> page = new PageInfo<Blog>(blogs);
//        model.addAttribute("blogPage", page);
//        List<Tag> tags = tagService.findList();
//        model.addAttribute("tags",tags);
//        List<Category> categories = categoryService.findList();
//        model.addAttribute("categories", categories);
//        List<Blog> hot = blogService.findHotList();

        String path = "admin/list?tag=" + tag + "&categoryId=" + categoryId + "&";
        model.addAttribute(new Tip(path));
        return "forward:/articles?tag=" + tag + "&categoryId=" + categoryId + "&pageNum=" + pageNum + "&pageSize=" + pageSize + "&adminFlag=true";
//        return "/admin/list";
    }
}
