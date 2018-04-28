package cn.shuangbofu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ericfu on 2018/3/13.
 */
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
