package com.pizzashop.dao;

import java.util.List;

import com.pizzashop.beans.Pizza;
import com.pizzashop.request.OrderRequest;
import com.pizzashop.response.BillResponse;

public interface PizzaDao {

	public void orderPizza(OrderRequest orderRequest);

	public List<Pizza> showMenu();

	public BillResponse getBill(Integer userid);

	public void modifyPizza(Pizza pizza);

	public void addPizza(Pizza pizza);

	public void deletePizza(Integer pizzaId);

}
