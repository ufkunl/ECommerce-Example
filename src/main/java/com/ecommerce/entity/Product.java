package com.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @developer -- ufukunal
 */

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

}
