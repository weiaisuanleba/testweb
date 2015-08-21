package permission.test;

import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import web.test.service.impl.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录、退出 Created by WK on 2015/3/2.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录
     *
     * @param account    登录账号
     * @param password   登录密码
     * @param rememberMe 记住我
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, String> login(final String account, final String password, final boolean rememberMe) {
        String error = "";

        try {
            Subject subject = SecurityUtils.getSubject();
            Base64Digester base64Digester = new Base64Digester();
            String enPassword = (base64Digester.encrypt(password));
            enPassword = password;
            UsernamePasswordToken token = new UsernamePasswordToken(account, enPassword);
            token.setRememberMe(rememberMe);
            subject.login(token);

            LOGGER.info("login------------");
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch 处理
            error = "用户名/密码错误";
            LOGGER.error("登录其他错误：{}", e.getMessage());
        } catch (Exception ex) {
            error = "用户名/密码错误";
            LOGGER.error("登录其他错误：{}", ex.getMessage());
            ex.printStackTrace();
        }
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (!Strings.isNullOrEmpty(error)) {//出错了，返回登录页面
            resultMap.put("error", error);
        } else {//登录成功
            resultMap.put("success", "/testweb/src/controller.html");
        }
        return resultMap;

//        ModelAndView modelAndView = new ModelAndView();
//        if (!Strings.isNullOrEmpty(error)) {//出错了，返回登录页面
//            modelAndView.addObject("message", error);
//            modelAndView.clear();
//            //modelAndView.setViewName("redirect:/login/login.html");
//        } else {//登录成功
//            modelAndView.setViewName("redirect:/tempweb/login.html");
//        }
//        return modelAndView;
    }

    /**
     * 用户退出
     */
    @RequestMapping(value = "/logout")
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated() || subject.isRemembered()) {
            subject.logout();
        }
    }

    /**
     * 验证是否登录
     *
     * @return 登录结果
     */
    @RequestMapping(value = "/isAuthenticated")
    public boolean isAuthenticated() {
        Subject subject = SecurityUtils.getSubject();
        boolean result = subject.isAuthenticated() || subject.isRemembered();
        return result;
    }

}
