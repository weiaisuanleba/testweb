package web.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.test.pojo.BasePojo;
import web.test.service.IBaseService;

import java.io.File;
import java.util.List;

/**
 * 基础服务，提供通用增删改查服务的封装
 *
 * @author panhongliang
 */
@SuppressWarnings("rawtypes")
public abstract class BaseService<T extends BasePojo, K> implements IBaseService<T, K> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);


    public String getServiceId() {
        return null;
    }

    public int deleteById(K id) {
        return 0;
    }

    public int deleteByIds(List<K> ids) {
        return 0;
    }

    public int deleteByPojo(T pojo) {
        return 0;
    }

    public List<T> getAll() {
        return null;
    }

    public T getById(K id) {
        return null;
    }

    public T getByIdFromCache(K id) {
        return null;
    }

    public List<T> getByIds(List<K> ids) {
        return null;
    }

    public List<T> getByPojo(T pojo) {
        return null;
    }

    public int modify(T row) {
        return 0;
    }

    public int modifySelective(T row) {
        return 0;
    }

    public int modifyBatchSelective(List<T> rows) {
        return 0;
    }

    public int save(T row) {
        return 0;
    }

    public int saveSelective(T row) {
        return 0;
    }

    public int saveBatch(List<T> rows) {
        return 0;
    }

    public String runSqlFile(File sqlScriptFile) {
        return null;
    }

    public String runSqlScript(String sqlScript) {
        return null;
    }

}
