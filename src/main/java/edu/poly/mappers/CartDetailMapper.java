package edu.poly.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.poly.dto.CartDTO;
import edu.poly.dto.CartDetailDTO;
import edu.poly.entity.Cart;
import edu.poly.entity.Cartdetail;
@Component
public class CartDetailMapper {
	@Autowired
	private ModelMapper mapper;
	public Cartdetail convertToEntity(CartDetailDTO cartdetailDTO) {
		Cartdetail entity = new Cartdetail();
		mapper.map(cartdetailDTO, entity);
		return entity;
	}
	
	public CartDetailDTO convertToDTO(Cartdetail entity) {
		CartDetailDTO cartdetailDTO = new CartDetailDTO();
		mapper.map(entity, cartdetailDTO);
		return cartdetailDTO;
	}
}
