package com.pizzashop.services;

import java.util.List;

import com.pizzashop.beans.Pizza;
import com.pizzashop.request.OrderRequest;
import com.pizzashop.response.BillResponse;

public interface PizzaService {

	public void orderPizza(OrderRequest request);

	public List<Pizza> showMenu();

	public BillResponse getBill(Integer userid);

	public void modifyPizza(Pizza pizza);

	public void addPizza(Pizza pizza);

	public void deletePizza(Integer pizzaId);

}
