package cn.shuangbofu.controller;

import cn.shuangbofu.entity.Blog;
import cn.shuangbofu.entity.Category;
import cn.shuangbofu.entity.Tag;
import cn.shuangbofu.service.BlogService;
import cn.shuangbofu.service.CategoryService;
import cn.shuangbofu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by ericfu on 2018/3/13.
 */
@Controller
public class mainController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

//    @GetMapping("/archive")
//    public String archive(Model model) {
//        Map<Integer, List<Blog>> archiveMap = blogService.findArchive();
//        model.addAttribute("archiveMap", archiveMap);
//
//        return "archive";
//    }
//    @GetMapping("/about")
//    public String about() {
//
//        return "about";
//    }

}
