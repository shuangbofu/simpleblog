package cn.shuangbofu.aspect;

import cn.shuangbofu.entity.Category;
import cn.shuangbofu.service.CategoryService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ericfu on 2018/3/24.
 */
@Aspect
@Component
public class CatalogAspect {

//    @Autowired
//    private CategoryService categoryService;
//
//    @Pointcut("execution(public * cn.shuangbofu.controller.*.*(..))")
//    public void verify(){}
//
//    @Before("verify()")
//    public void doVerify() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        HttpSession session = request.getSession();
//        if (session.getAttribute("categories")==null) {
//            List<Category> categories = categoryService.findAll();
//            session.setAttribute("categories", categories);
//        }
//    }
}
