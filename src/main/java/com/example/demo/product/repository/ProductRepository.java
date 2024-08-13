package com.example.demo.product.repository;

import com.example.demo.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.*;

//DB와 연결 및 소통
//@Repository //주석 처리 후 ApplicationConfiguration 설정 파일에서 구현
public class ProductRepository {

    @Autowired
    EntityManager entityManager; // CRUD 작업을 수행
    //DataSource dataSource;

    private Map<Integer, Product> db = new HashMap<Integer, Product>();
    //맵은 인터페이스이고 밑에 여러 구현체를 쓸 수 있다. 그 중 HashMap을 사용
    private int id = 1;

    //dataSource로 터널 뚫어보기(=DB와 커넥션 만들기)
/*    public void makeConnection(){
        System.out.println("터널링!!");
        DataSourceUtils.getConnection(dataSource); // 내가 가져온 데이터 객체로 터널링
    }*/


    public List<Product> findProducts() {
        //return new ArrayList<>(db.values());
        return entityManager// 엔티티매니저 호출
                .createQuery("select p from Product p", Product.class) // 이 쿼리(JPQL)를 만들어서
                .getResultList(); //결과 내놔
    }

    public Product findProduct(String id){
        return db.get(Integer.valueOf(id)); //.get은 데이터가 없어도 오류가 발생안하고 그대로 전달함.
        //그래서 null값인지 아닌지 이 부분을 잘 생각해서 예외처리 해야함
    }


/*    public void save(String productName){
        System.out.println(productName);
        db.put(id++, productName);
    }*/

    public void save(Product product){
        System.out.println(product.getName());
        //db.put( id++, product);
        entityManager.persist(product);

    }
    //수정 삭제 구현해보기
}
