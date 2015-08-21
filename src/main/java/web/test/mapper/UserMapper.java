package web.test.mapper;


import web.test.pojo.User;

/**
 * 表: test_user<br>
 * <p/>
 * 用户.
 *
 * @mbggenerated
 */
public interface UserMapper extends IBaseMapper<User, String> {

    /**
     *  判断账号是否存在
     * @param account 账号
     * @return 是否存在
     */
    Integer isExist(String account);

    /**
     *  根据账号获取用户信息
     * @param account 账号
     * @return 用户信息
     */
    User getUserByAccount(String account);


}