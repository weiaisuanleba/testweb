package web.test.service.impl;


import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import web.test.mapper.UserMapper;
import web.test.pojo.User;
import web.test.service.IUserService;

import java.util.List;

/**
 * 表: test_user<br>
 * 用户.
 */
@Service
public class UserService extends BaseService<User, String> implements IUserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        LOGGER.debug("userMapper", userMapper);
        this.userMapper = userMapper;
    }

    public List<User> getAll() {
        return userMapper.getAll();
    }

    public Boolean isExist(String account) {
        return userMapper.isExist(account) > 0;
    }


    /**
     *  根据账号获取用户信息
     * @param account 账号
     * @return 用户信息
     */
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    public int save(User user) {
        return userMapper.save(user);
    }

}