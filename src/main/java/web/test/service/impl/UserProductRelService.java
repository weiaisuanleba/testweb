package web.test.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.test.mapper.UserMapper;
import web.test.mapper.UserProductRelMapper;
import web.test.pojo.User;
import web.test.pojo.UserProductRel;
import web.test.service.IUserProductRelService;
import web.test.service.IUserService;

import java.util.List;

/**
 * 表: test_user<br>
 * 用户.
 */
@Service
public class UserProductRelService extends MyBaseService<UserProductRel, UserProductRel> implements IUserProductRelService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserProductRelService.class);

    @Autowired
    private UserProductRelMapper userProductRelMapper;


    @Override
    public UserProductRel selectByPrimaryKey(UserProductRel id) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(UserProductRel pojo) {
        return userProductRelMapper.deleteByPrimaryKey(pojo);
    }

    @Override
    public int insert(UserProductRel pojo) {
        return userProductRelMapper.insert(pojo);
    }

    @Override
    public int insertSelective(UserProductRel pojo) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserProductRel pojo) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(UserProductRel pojo) {
        return 0;
    }
}