package web.test.mapper;

import web.test.pojo.Product;

import java.util.List;

public interface ProductMapper {


    /**
     * 获取用户拥有的设备
     *
     * @mbggenerated Tue Aug 11 20:48:07 CST 2015
     */
    List<Product> list(String userId);

    /**
     *  根据 产品序列号 获取产品信息
     *
     * @mbggenerated Sun Aug 16 09:40:30 CST 2015
     */
    Product selectByModelNumber(String modelNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_product
     *
     * @mbggenerated Tue Aug 11 20:48:07 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_product
     *
     * @mbggenerated Tue Aug 11 20:48:07 CST 2015
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_product
     *
     * @mbggenerated Tue Aug 11 20:48:07 CST 2015
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_product
     *
     * @mbggenerated Tue Aug 11 20:48:07 CST 2015
     */
    Product selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_product
     *
     * @mbggenerated Tue Aug 11 20:48:07 CST 2015
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_product
     *
     * @mbggenerated Tue Aug 11 20:48:07 CST 2015
     */
    int updateByPrimaryKey(Product record);
}