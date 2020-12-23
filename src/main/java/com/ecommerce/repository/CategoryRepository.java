package com.ecommerce.repository;

import com.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @developer -- ufukunal
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


}
