/**
 * 
 */
package com.shopping.salesorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.shopping.salesorder.entity.SalesOrder;

/**
 * @author 146374
 *
 */
@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long>{};
