package cn.shuangbofu.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ericfu on 2018/4/16.
 */
@Controller
public class BlogErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        System.out.println("-----------");
        return ERROR_PATH;
    }

    @RequestMapping("/error")
    public String error() {
        return "common/error";
    }
}
