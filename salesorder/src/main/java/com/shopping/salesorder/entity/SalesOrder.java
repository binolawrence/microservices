/**
 * 
 */
package com.shopping.salesorder.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author 146374
 *
 */

@Entity
@Table(name="SALES_ORDER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SalesOrder {

	/*
	 * @OneToMany(mappedBy="sales_order") private Set<OrderLineItem> items;
	 */
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the cust_id
	 */
	public Long getCust_id() {
		return cust_id;
	}
	/**
	 * @param cust_id the cust_id to set
	 */
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	/**
	 * @return the order_desc
	 */
	public String getOrder_desc() {
		return order_desc;
	}
	/**
	 * @param order_desc the order_desc to set
	 */
	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}
	/**
	 * @return the order_date
	 */
	public Date getOrder_date() {
		return order_date;
	}
	/**
	 * @param order_date the order_date to set
	 */
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	/**
	 * @return the total_price
	 */
	public BigDecimal getTotal_price() {
		return total_price;
	}
	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	Long cust_id;
	String order_desc;
	@Temporal(TemporalType.TIMESTAMP)
    public Date order_date = new Date();
	BigDecimal total_price;
	
}
