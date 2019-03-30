package com.pizzashop.request;

import java.time.LocalDateTime;
import java.util.List;

import com.pizzashop.beans.Pizza;

public class OrderRequest {
	private Integer id;
	private Integer userId;
	private List<Pizza> pizzaList;
	private double totalAmount;
	private String payby;

	private String createdBy;
	private LocalDateTime creationTime;
	private String updatedBy;
	private LocalDateTime updationTime;

	/**
	 * @return the pizzaList
	 */
	public List<Pizza> getPizzaList() {
		return pizzaList;
	}

	/**
	 * @param pizzaList
	 *            the pizzaList to set
	 */
	public void setPizzaList(List<Pizza> pizzaList) {
		this.pizzaList = pizzaList;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount
	 *            the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the payby
	 */
	public String getPayby() {
		return payby;
	}

	/**
	 * @param payby
	 *            the payby to set
	 */
	public void setPayby(String payby) {
		this.payby = payby;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the creationTime
	 */
	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime
	 *            the creationTime to set
	 */
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updationTime
	 */
	public LocalDateTime getUpdationTime() {
		return updationTime;
	}

	/**
	 * @param updationTime
	 *            the updationTime to set
	 */
	public void setUpdationTime(LocalDateTime updationTime) {
		this.updationTime = updationTime;
	}

}
