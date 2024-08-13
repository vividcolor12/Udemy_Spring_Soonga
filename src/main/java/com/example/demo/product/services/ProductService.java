package com.example.demo.product.services;

import com.example.demo.product.model.Product;
import com.example.demo.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//일을 하기위해서 Repository에게 데이터베이스에 저장하고 수정
@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

/*
    public void makeConnection(){
        productRepository.makeConnection();
    }
*/

    //전체조회
    public List<Product> findProducts() {
        return productRepository.findProducts();
    }

    //개별조회
    public Product findProduct(String id) {
        return productRepository.findProduct(id);
    }
   /* public void saveProduct(String product) {
        productRepository.save(product);
    }*/
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }


}
