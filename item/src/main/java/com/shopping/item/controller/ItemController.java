/**
 * 
 */
package com.shopping.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.item.entity.Item;
import com.shopping.item.service.ItemService;

/**
 * @author 146374
 *
 */
@RequestMapping("/itemservice")
@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/items/{itemId}")
	public Item getItem(@PathVariable Long itemId) {
		return itemService.getItem(itemId);
		
	}
	
	@GetMapping("/items")
	public List<Item> getItem() {
		return itemService.getItems();
		
	}
	
	
}
