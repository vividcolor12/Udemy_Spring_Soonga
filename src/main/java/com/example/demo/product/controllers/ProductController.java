package com.example.demo.product.controllers;

import com.example.demo.product.model.Product;
import com.example.demo.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//컨트롤러는 요청을 받아서 서비스에게 일을 시키고 결과를 받음
/*@Controller
@ResponseBody*/ //@Controller을 사용시 @ResponseBody을 안하면 API 요청 응답이 안간다.
//RestAPI
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/products")
public class ProductController {
    //사용자(화면) 요청을 던지면 그걸 받아서
    //요청에 맞는 메소드를 실행 시킵니다.
    // 그 안에서, 그에 맞는 로직을 수행할 수 있도록 서비스한테 시키는것
@Autowired
    private ProductService productService;
/*
    @GetMapping("/connectdb")
    public void makeConnection(){
        productService.makeConnection();
    }*/

    //전체상품 조회
    @GetMapping
    public List<Product> findProducts() {
        return productService.findProducts(); //JOSN Array 형태로 나옴
    }

    //개별 상품 조회
    @GetMapping("/{id}")
    public Product findProduct(@PathVariable("id") String id) {
        //ProductService productService = new ProductService(); // 서비스 객체를 개발자가 생성

        return productService.findProduct(id);
    }


    @PostMapping
/*    public void saveProduct(@RequestParam(value = "name") String productName) {
        //localhoat:8080/produts?name=______ => productName
        System.out.println(productName);
        productService.saveProduct(productName);
    }*/
    public void saveProduct(@RequestBody Product product) {
        //필드 이름을 보고 체크해서 값을 넣어준다.
        productService.saveProduct(product);
    }

    //상품 등록


}
