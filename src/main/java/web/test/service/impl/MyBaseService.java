package web.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.test.service.IMyBaseService;

/**
 * 基础服务，提供通用增删改查服务的封装
 *
 * @author panhongliang
 */
@SuppressWarnings("rawtypes")
public abstract class MyBaseService<T , K> implements IMyBaseService<T, K> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(MyBaseService.class);


}
