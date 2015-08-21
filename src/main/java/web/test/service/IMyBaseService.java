package web.test.service;

/**
 * Created by lenovo1 on 2015/8/15.
 */
public interface IMyBaseService<T, K> {

    /**
     * 根据主键获取
     *
     * @param id 主键
     * @return 操作行数
     */
    T selectByPrimaryKey(K id);

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 操作行数
     */
    int deleteByPrimaryKey(K id);

    /**
     * 插入一条数据
     *
     * @param pojo 数据对象
     * @return 操作行数
     */
    int insert(T pojo);

    /**
     * 插入一条数据
     *
     * @param pojo 数据对象
     * @return 操作行数
     */
    int insertSelective(T pojo);

    /**
     * 更新一条数据
     *
     * @param pojo 数据对象
     * @return 操作行数
     */
    int updateByPrimaryKey(T pojo);

    /**
     * 更新一条数据
     *
     * @param pojo 数据对象
     * @return 操作行数
     */
    int updateByPrimaryKeySelective(T pojo);

}
