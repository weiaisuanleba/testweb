package web.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.test.pojo.Product;
import web.test.pojo.User;
import web.test.service.impl.ProductService;

import java.util.List;

/**
 * Created by WK on 2015/8/16.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public List<Product> list() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        return productService.list(user.getId());
    }

    @RequestMapping("/isexist")
    public boolean add(String modelNumber) {
        Product product = productService.selectByModelNumber(modelNumber);
        return (product != null);
    }


}
