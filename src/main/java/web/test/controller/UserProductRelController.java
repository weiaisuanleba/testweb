package web.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.test.pojo.Product;
import web.test.pojo.User;
import web.test.pojo.UserProductRel;
import web.test.service.impl.ProductService;
import web.test.service.impl.UserProductRelService;

import java.util.List;

/**
 * Created by WK on 2015/8/16.
 */
@RestController
@RequestMapping("/userproductrel")
public class UserProductRelController {

    @Autowired
    private UserProductRelService userProductRelService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/add")
    public int add(String modelNumber) {
        Product product = productService.selectByModelNumber(modelNumber);
        if (product == null) {
            return 0;
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        UserProductRel userProductRel = new UserProductRel();
        userProductRel.setUserId(user.getId());
        userProductRel.setProductId(product.getId());
        return userProductRelService.insert(userProductRel);
    }


}
