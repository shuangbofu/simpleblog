package cn.shuangbofu.handler;

import cn.shuangbofu.exception.SiteException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by ericfu on 2018/3/13.
 */
@ControllerAdvice
public class SiteExceptionHandler {

    @ExceptionHandler(value = SiteException.class)
    public String handlerSiteException(SiteException e, Model model) {
        model.addAttribute("error", e);
        return "common/error";
    }
}
