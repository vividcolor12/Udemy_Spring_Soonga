package com.example.demo.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product  {
    //DB에서 ID는 식별자인데 왜 오류??
    //이곳은 자바 코드 hibernate(Entitymanager, .. JPA 구현체)
    //EntityContext안에서 자기 나름의 indetifier(식별자 = DB의 PK)를 가지고 Entity를 구별
    //디비의 식별자와 달라도 되지만 1:1 매핑!!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
