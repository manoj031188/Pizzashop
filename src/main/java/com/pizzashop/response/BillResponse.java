package com.pizzashop.response;

import java.util.List;

import com.pizzashop.beans.Pizza;

public class BillResponse {
	private String userName;
	private List<Pizza> pizzaList;
	private double totalAmount;
	private String payby;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

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

}
