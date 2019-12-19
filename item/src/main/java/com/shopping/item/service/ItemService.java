/**
 * 
 */
package com.shopping.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopping.item.entity.Item;
import com.shopping.item.repository.ItemRepository;

/**
 * @author 146374
 *
 */
@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public Item getItem(long Id) {
		return itemRepository.getOne(Id);
	}
	
	public List<Item> getItems() {
		return itemRepository.findAll();
	}
	
}
