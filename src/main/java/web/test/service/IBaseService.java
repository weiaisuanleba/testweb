package web.test.service;


import web.test.pojo.BasePojo;

import java.io.File;
import java.util.List;

/**
 * 数据服务接口
 *
 * @param <T> bean类型
 * @param <K> ID类型<br>
 * @author panhongliang
 */
@SuppressWarnings("rawtypes")
public interface IBaseService<T extends BasePojo, K> {
    /**
     * 服务id
     *
     * @return String
     */
    String getServiceId();

    /**
     * 按ID删除记录
     *
     * @param id 记录ID
     * @return 删除数目
     */
    int deleteById(K id);

    /**
     * 批量删除多条记录
     *
     * @param ids 记录ID列表
     * @return 删除数目
     */
    int deleteByIds(List<K> ids);

    /**
     * 根据pojo属性批量删除对象
     *
     * @param pojo
     * @return String
     */
    int deleteByPojo(T pojo);

    /**
     * 获取所有记录
     *
     * @return 所有记录
     */
    List<T> getAll();

    /**
     * 按ID获取单行记录
     *
     * @param id 记录ID
     * @return 记录
     */
    T getById(K id);

    /**
     * 按ID获取单行记录
     *
     * @param id 记录ID
     * @return 记录
     */
    T getByIdFromCache(K id);

    /**
     * 按ID获取多条记录
     *
     * @param ids 记录ID类别
     * @return 记录列表
     */
    List<T> getByIds(List<K> ids);

    /**
     * 根据对象本身信息，进行过滤
     *
     * @param pojo
     * @return List<T>记录列表
     */
    List<T> getByPojo(T pojo);

    /**
     * 更新单条记录
     *
     * @param row 记录（ID中必须有值）
     * @return 修改数目
     */
    int modify(T row);

    /**
     * 选择性保存<br>
     * 只保存非空字段
     *
     * @param row
     * @return 修改数目
     */
    int modifySelective(T row);

    /**
     * 批量选择性保存<br>
     * 只保存非空字段
     *
     * @param rows
     * @return 修改数目
     */
    int modifyBatchSelective(List<T> rows);

    /**
     * 保存一条记录
     *
     * @param row 记录
     * @return 修改数目
     */
    int save(T row);

    /**
     * 选择性保存<br>
     * 只保存非空字段
     *
     * @param row 记录
     * @return 修改数目
     */
    int saveSelective(T row);

    /**
     * 批量保存对象
     *
     * @param rows 对象列表
     * @return 修改数目
     */
    int saveBatch(List<T> rows);

    /**
     * 执行sql脚本文件
     *
     * @param sqlScriptFile File
     * @return String 错误信息
     */
    String runSqlFile(final File sqlScriptFile);

    /**
     * 执行sql脚本文件
     *
     * @param sqlScript 文本内容
     * @return String 错误信息
     */
    String runSqlScript(final String sqlScript);

}
