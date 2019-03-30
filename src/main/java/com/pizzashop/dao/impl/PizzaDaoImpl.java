package com.pizzashop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.pizzashop.beans.Pizza;
import com.pizzashop.dao.PizzaDao;
import com.pizzashop.request.OrderRequest;
import com.pizzashop.response.BillResponse;
import com.pizzashop.testproject.TestprojectApplication;

@Component
public class PizzaDaoImpl implements PizzaDao {

	static final String GET_ALL_PIZZA_QUERY = "select id,name,price,category from pizza";
	static final String INSERT_BILL_QUERY = "Insert into bill (user_id,total_amount,transaction_type) values(?,?,?)";
	static final String INSERT_BILL_PIZZA_MAPPING_QUERY = "Insert into `bill_pizza_mapping` (order_id,pizza_id) values(?,?)";
	static final String ADD_PIZZA_QUERY = "Insert into pizza (name,category,price) values(?,?,?)";
	static final String UPDATE_PIZZA_QUERY = "update pizza set name=?,category=?,price=? where id=?";
	static final String DELETE_PIZZA_QUERY = "delete from pizza where id=?";
	static final String GET_BILL_QUERY = "select user_name,email, bl.id as order_id,total_amount,transaction_type from user usr left join bill bl on usr.id=bl.user_id where user_id=? order by 1 desc limit 1";
	static final String GET_PIZZA_BY_ORDER_ID_QUERY = "select id,name,price,category from pizza pz where id in (select pizza_id from bill_pizza_mapping where order_id=?)";

	private static final Logger log = LoggerFactory.getLogger(TestprojectApplication.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void orderPizza(OrderRequest orderrequest) {
		GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL_QUERY, new String[] { "id" });
			preparedStatement.setInt(1, orderrequest.getUserId());
			preparedStatement.setDouble(2, orderrequest.getTotalAmount());
			preparedStatement.setString(3, orderrequest.getPayby());
			return preparedStatement;
		}, generatedKeyHolder);

		for (int j = 0; j < orderrequest.getPizzaList().size(); j += orderrequest.getPizzaList().size()) {
			jdbcTemplate.batchUpdate(INSERT_BILL_PIZZA_MAPPING_QUERY, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Pizza pizza = orderrequest.getPizzaList().get(i);
					ps.setInt(1, generatedKeyHolder.getKey().intValue());
					ps.setInt(2, pizza.getId());
				}

				@Override
				public int getBatchSize() {
					return orderrequest.getPizzaList().size();
				}
			});
		}
		log.info("Order Added successfully");
	}

	public List<Pizza> showMenu() {
		List<Pizza> pizzas = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_ALL_PIZZA_QUERY);
		for (Map<String, Object> row : rows) {
			Pizza pizza = new Pizza();
			pizza.setId((Integer) row.get("id"));
			pizza.setName((String) row.get("name"));
			pizza.setPrice((Double) row.get("price"));
			pizza.setCategory((String) row.get("category"));
			pizzas.add(pizza);
		}
		log.info("all Menu Items fetched");
		return pizzas;
	}

	public BillResponse getBill(Integer userid) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_BILL_QUERY, userid);
		int orderId = 0;
		BillResponse billResponse = new BillResponse();
		for (Map<String, Object> row : rows) {
			billResponse.setUserName((String) row.get("user_name"));
			billResponse.setTotalAmount((Double) row.get("total_amount"));
			billResponse.setPayby((String) row.get("transaction_type"));
			orderId = (Integer) row.get("order_id");
		}
		List<Pizza> pizzas = new ArrayList<>();
		if (orderId != 0) {
			List<Map<String, Object>> pizzaRows = jdbcTemplate.queryForList(GET_PIZZA_BY_ORDER_ID_QUERY, orderId);
			for (Map<String, Object> row : pizzaRows) {
				Pizza pizza = new Pizza();
				pizza.setId((Integer) row.get("id"));
				pizza.setName((String) row.get("name"));
				pizza.setPrice((Double) row.get("price"));
				pizza.setCategory((String) row.get("category"));
				pizzas.add(pizza);
			}
		}
		billResponse.setPizzaList(pizzas);
		log.info("Bill fetched for :: " + userid);
		return billResponse;

	}

	public void modifyPizza(Pizza pizza) {
		int status = jdbcTemplate.update(UPDATE_PIZZA_QUERY, pizza.getName(), pizza.getCategory(), pizza.getPrice(), pizza.getId());
		if (status != 0) {
			log.info("Pizza data updated for ID " + pizza.getId());
		} else {
			log.info("No Pizza found with ID " + pizza.getId());
		}
	}

	public void addPizza(Pizza pizza) {
		int status = jdbcTemplate.update(ADD_PIZZA_QUERY, pizza.getName(), pizza.getCategory(), pizza.getPrice());
		if (status != 0) {
			log.info("New Pizza Added Successfully " + pizza.getId());
		} else {
			log.info("New Pizza is not added in database" + pizza.getId());
		}
	}

	public void deletePizza(Integer pizzaId) {
		int status = jdbcTemplate.update(DELETE_PIZZA_QUERY, pizzaId);
		if (status != 0) {
			log.info("Pizza deleted for ID" + pizzaId);
		} else {
			log.info("No Pizza found" + pizzaId);
		}
	}

}
