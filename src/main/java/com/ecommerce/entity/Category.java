package com.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @developer -- ufukunal
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CATEGORİES")
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String name;

}
