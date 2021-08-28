package edu.poly.dto;

import java.util.Date;

import edu.poly.entity.Cart;
import edu.poly.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class CartDetailDTO {
	private Integer id;
	
	private Cart cart_id;
	
	private Product product_id;
	
	private Date createdate = new Date();
	
	private Integer quantity;
}
