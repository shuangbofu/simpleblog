package cn.shuangbofu.controller;

import cn.shuangbofu.dto.BlogDetail;
import cn.shuangbofu.entity.Blog;
import cn.shuangbofu.entity.Category;
import cn.shuangbofu.entity.Profile;
import cn.shuangbofu.entity.Tag;
import cn.shuangbofu.enums.TipEnum;
import cn.shuangbofu.service.BlogService;
import cn.shuangbofu.service.CategoryService;
import cn.shuangbofu.service.ProfileService;
import cn.shuangbofu.service.TagService;
import cn.shuangbofu.vo.Tip;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by ericfu on 2018/3/11.
 */
@Controller
//@RequestMapping("/")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProfileService profileService;


    @GetMapping("/articles")
    public String articles(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
                          @RequestParam(value = "tag", required = false, defaultValue = "") String tag,
                          @RequestParam(value = "categoryId", required = false, defaultValue = "0") Integer categoryId,
                           @RequestParam(value = "categoryName", required = false, defaultValue = "0") String categoryName,
                          @RequestParam(value="adminFlag", required = false, defaultValue = "false") Boolean adminFlag,
                          Model model) {

        initCommon(model, adminFlag);
        List<Blog> blogs = blogService.findAll(categoryId, tag, pageNum, pageSize);
        PageInfo<Blog> page = new PageInfo<Blog>(blogs);
        model.addAttribute("blogPage", page);
        if (categoryId!=0) {
            model.addAttribute("tip",new Tip(TipEnum.CATEGORY_TIP, categoryName, categoryId));
        } else if(!"".equals(tag)){
            model.addAttribute("tip", new Tip(TipEnum.TAG_TIP, tag));
        } else {
            model.addAttribute("tip", new Tip(TipEnum.NONE_TIP));
        }
        if(!adminFlag) {
            return "blog/list";
        } else {
            return "admin/list";
        }

    }
    @GetMapping("/tag/{tag}")
    public String articles(@PathVariable("tag") String tag,
                           @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        return "forward:/articles?tag=" + tag + "&pageNum=" + pageNum + "&pageSize=" + pageSize;
    }

    @GetMapping("/category/{categoryId}")
    public String articlesByCategoryId(@PathVariable("categoryId") Integer categoryId,
                           @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        Category category = categoryService.findOne(categoryId);
        return "forward:/articles?categoryId=" + categoryId + "&pageNum=" + pageNum + "&pageSize=" + pageSize + "&categoryName=" + category.getName();
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable("id") Integer id,
                          Model model) {
        initCommon(model, false);
        BlogDetail blogDetail = blogService.findOne(id);
        model.addAttribute("blog", blogDetail);
        model.addAttribute("tip",new Tip(TipEnum.NONE_TIP));
        return "blog/detail";
    }

    private void initCommon(Model model, Boolean flag) {
        if (!flag) {
            List<Blog> hot = blogService.findHotList();
            model.addAttribute("hot", hot);
            List<Blog> spacial = blogService.findSpecialList();
            model.addAttribute("special", spacial);
            Profile profile = profileService.get();
            model.addAttribute("profile", profile);
        }
        List<Tag> tags = tagService.findList();
        model.addAttribute("tags",tags);
        List<Category> categories = categoryService.findList();
        model.addAttribute("categories", categories);

    }
}
