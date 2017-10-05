package com.testDao;

import com.client.Department;
import com.client.Product;
import com.dao.DepartmentDao;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository("productDaoTestImpl")
public class ProductDaoTestImpl implements ProductDaoTest {

    @Resource(name = "departmentDaoImpl")
    private DepartmentDao departmentDao;

    @Resource(name = "departmentDaoTestImpl")
    private DepartmentDaoTest departmentDaoTest;

    public Product createProduct(String productName, int price, String departmentName) {
        Department department = departmentDaoTest.createDepartment(departmentName);
        department.setId(departmentDao.add(departmentName));
        Product product = new Product();
        product.setName(productName);
        product.setPrice(price);
        product.setDepartment(department);
        return product;
    }
}