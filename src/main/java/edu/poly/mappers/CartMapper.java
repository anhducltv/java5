package edu.poly.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.poly.dto.AccountDTO;
import edu.poly.dto.CartDTO;
import edu.poly.entity.Account;
import edu.poly.entity.Cart;

@Component
public class CartMapper {
	@Autowired
	private ModelMapper mapper;
	

	
	public Cart convertToEntity(CartDTO cartDTO) {
		Cart entity = new Cart();
		mapper.map(cartDTO, entity);
		return entity;
	}
	
	public CartDTO convertToDTO(Cart entity) {
		CartDTO cartDTO = new CartDTO();
		mapper.map(entity, cartDTO);
		return cartDTO;
	}
}
