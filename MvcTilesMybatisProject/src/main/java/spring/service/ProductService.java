package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.ProductDao;

@Service
public class ProductService {

    @Autowired
    ProductDao dao;


}
