package web.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import web.test.mapper.ProductMapper;
import web.test.pojo.Product;
import web.test.service.IProductService;

import java.util.List;

/**
 * Created by WK on 2015/8/16.
 */
public class ProductService extends MyBaseService<Product, String> implements IProductService {


    @Autowired
    private ProductMapper productMapper;


    @Override
    public Product selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Product pojo) {
        return 0;
    }

    @Override
    public int insertSelective(Product pojo) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Product pojo) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Product pojo) {
        return 0;
    }

    @Override
    public List<Product> list(String userId) {
        return productMapper.list(userId);
    }

    @Override
    public Product selectByModelNumber(String modelNumber) {
        return productMapper.selectByModelNumber(modelNumber);
    }
}
