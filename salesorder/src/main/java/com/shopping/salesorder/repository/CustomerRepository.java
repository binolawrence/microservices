/**
 * 
 */
package com.shopping.salesorder.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.salesorder.entity.Customer;

/**
 * @author 146374
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{};

