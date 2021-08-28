package edu.poly.dto;

import java.util.Date;

import edu.poly.entity.Account;
import edu.poly.entity.Order;
import edu.poly.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderdetailDTO {
	private Integer id;
	
	private Order order_id;
	
	private Product product_id;
	
	private Integer price;
	
	private Integer quantity;
}
