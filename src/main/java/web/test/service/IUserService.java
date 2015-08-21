package web.test.service;


import web.test.pojo.User;

/**
 * 表: test_user<br>
 * 用户.
 */

public interface IUserService extends IBaseService<User, String> {

    /**
     *  判断账号是否存在
     * @param account  账号
     * @return  是否存在
     */
    public Boolean isExist(String account);


    /**
     *  根据账号获取用户信息
     * @param account 账号
     * @return 用户信息
     */
    User getUserByAccount(String account);

}