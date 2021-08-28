package edu.poly.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.poly.dto.CategoryDTO;
import edu.poly.dto.OrderDTO;
import edu.poly.entity.Category;
import edu.poly.entity.Order;

@Component
public class OrderMapper {
	@Autowired
	private ModelMapper mapper;
	
	public Order convertToEntity(OrderDTO orderDTO) {
		Order entity = new Order();
		mapper.map(orderDTO, entity);
		return entity;
	}
	
	public OrderDTO convertToDTO(Order entity) {
		OrderDTO orderDTO = new OrderDTO();
		mapper.map(entity, orderDTO);
		return orderDTO;
	}
}
