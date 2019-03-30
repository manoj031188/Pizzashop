package com.pizzashop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pizzashop.beans.Pizza;
import com.pizzashop.dao.PizzaDao;
import com.pizzashop.request.OrderRequest;
import com.pizzashop.response.BillResponse;
import com.pizzashop.services.PizzaService;

@Component
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	PizzaDao pizzaDaoImpl;

	public void orderPizza(OrderRequest orderRequest) {
		pizzaDaoImpl.orderPizza(orderRequest);
	}

	public List<Pizza> showMenu() {
		return pizzaDaoImpl.showMenu();
	}

	public BillResponse getBill(Integer userid) {
		return pizzaDaoImpl.getBill(userid);
	}

	public void modifyPizza(Pizza pizza) {
		pizzaDaoImpl.modifyPizza(pizza);

	}

	public void addPizza(Pizza pizza) {
		pizzaDaoImpl.addPizza(pizza);
	}

	public void deletePizza(Integer pizzaId) {
		pizzaDaoImpl.deletePizza(pizzaId);
	}

}
