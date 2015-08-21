package web.test.service;


import web.test.pojo.Product;

import java.util.List;

/**
 * 表: test_user<br>
 * 用户.
 */

public interface IProductService extends IMyBaseService<Product, String> {

    List<Product> list(String account);

    Product selectByModelNumber(String modelNumber);

}