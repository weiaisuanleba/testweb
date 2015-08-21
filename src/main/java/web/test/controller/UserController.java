package web.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.test.pojo.User;
import web.test.service.impl.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo1 on 2015/7/31.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private static UserService userService;

    public void setUserService(UserService userService) {
        LOGGER.debug("test --------------", userService);
        System.out.println(userService);
        this.userService = userService;
    }

    @RequestMapping("/list")
    public List<User> list(User user) {
        List<User> users = userService.getAll();
        LOGGER.info("test_list", users);
        System.out.println(users);
        List<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setAccount("account");
        user1.setPassword("password");
        list.add(user1);
        return list;
    }

    /**
     *  判断账号是否纯在
     * @param account  账号
     * @return 是否存在
     */
    @RequestMapping("/isExist")
    public Boolean isExist(String account) {
        return userService.isExist(account);
    }

    /**
     * 注册用户
     *
     * @param user 用户实体
     * @return 创建用户个数
     */
    @RequestMapping("/register")
    public int register(final User user) {
        return userService.save(user);
    }


}
