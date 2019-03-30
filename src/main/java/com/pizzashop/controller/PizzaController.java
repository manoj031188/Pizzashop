package com.pizzashop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizzashop.beans.Pizza;
import com.pizzashop.request.OrderRequest;
import com.pizzashop.response.BillResponse;
import com.pizzashop.services.PizzaService;

@RestController
@RequestMapping(value = "pizzashop", produces = { MediaType.APPLICATION_JSON_VALUE })
public class PizzaController {

	@Autowired
	PizzaService PizzaServiceImpl;

	@GetMapping(value = "/showMenu")
	public List<Pizza> getMenu() {
		return PizzaServiceImpl.showMenu();
	}

	@PostMapping(value = "/order")
	public ResponseEntity<Void> orderPizza(@RequestBody OrderRequest request) {
		PizzaServiceImpl.orderPizza(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/bill")
	public BillResponse getbill(@RequestParam(name = "userId", required = true) Integer userid) {
		return PizzaServiceImpl.getBill(userid);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Void> addPizza(@RequestBody Pizza pizza) {
		PizzaServiceImpl.addPizza(pizza);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Void> modifyPizza(@RequestBody Pizza pizza) {
		PizzaServiceImpl.modifyPizza(pizza);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(value = "/delete")
	public ResponseEntity<Void> deletePizza(@RequestParam(name = "pizzaId", required = true) Integer pizzaId) {
		PizzaServiceImpl.deletePizza(pizzaId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
