/**
 * 
 */
package com.shopping.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.item.entity.Item;

/**
 * @author 146374
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{};
