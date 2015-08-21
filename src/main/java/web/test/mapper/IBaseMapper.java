package web.test.mapper;

import java.util.List;

/**
 * 基本batis映射接口
 *
 * @param <T> bean类型
 * @param <K> ID类型
 */
public interface IBaseMapper<T, K> {

    /**
     * 保存一条记录
     *
     * @param row 记录
     */
    int save(T row);

    /**
     * 批量保存对象
     *
     * @param rows 对象列表
     */
    int saveBatch(List<T> rows);

    /**
     * 选择性保存，只保存非空列 saveSelective.
     *
     * @param row
     * @return int
     */
    int saveSelective(T row);

    /**
     * 按ID获取单行记录
     *
     * @param id 记录ID
     * @return 记录
     */
    T getById(K id);

    /**
     * 按ID获取多条记录
     *
     * @param ids 记录ID类别
     * @return 记录列表
     */
    List<T> getByIds(List<K> ids);

    /**
     * 获取所有记录
     *
     * @return 所有记录
     */
    List<T> getAll();

    /**
     * 更新单条记录
     *
     * @param row 记录（ID中必须有值）
     */
    int modify(T row);

    /**
     * 选择性保存，只保存非空列 saveSelective.
     *
     * @param row
     * @return int
     */
    int modifySelective(T row);

    /**
     * 按ID删除记录
     *
     * @param id 记录ID
     */
    int deleteById(K id);

    /**
     * 批量删除多条记录
     *
     * @param ids 记录ID列表
     */
    int deleteByIds(List<K> ids);

}
