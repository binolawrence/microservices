/**
 * 
 */
package com.shopping.salesorder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author 146374
 *
 */

@Entity
@Table(name="ORDER_LINE_ITEM")
public class OrderLineItem {
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="order_id", nullable=false) private SalesOrder salesOrder;
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the item_name
	 */
	public String getItem_name() {
		return item_name;
	}
	/**
	 * @param item_name the item_name to set
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	/**
	 * @return the item_quantity
	 */
	public String getItem_quantity() {
		return item_quantity;
	}
	/**
	 * @param item_quantity the item_quantity to set
	 */
	public void setItem_quantity(String item_quantity) {
		this.item_quantity = item_quantity;
	}
	/**
	 * @return the order_id
	 */
	public long getOrder_id() {
		return order_id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	private String item_name;
	private String item_quantity;
	private long order_id;
	
}
