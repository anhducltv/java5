package edu.poly.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.poly.dto.OrderDTO;
import edu.poly.dto.OrderdetailDTO;
import edu.poly.entity.Order;
import edu.poly.entity.OrderDetail;

@Component
public class OrderDetailMapper {
	@Autowired
	private ModelMapper mapper;
	
	public OrderDetail convertToEntity(OrderdetailDTO orderdetailDTO) {
		OrderDetail entity = new OrderDetail();
		mapper.map(orderdetailDTO, entity);
		return entity;
	}
	
	public OrderdetailDTO convertToDTO(OrderDetail entity) {
		OrderdetailDTO orderdetailDTO = new OrderdetailDTO();
		mapper.map(entity, orderdetailDTO);
		return orderdetailDTO;
	}
}
