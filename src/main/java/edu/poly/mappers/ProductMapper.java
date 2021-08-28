package edu.poly.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import edu.poly.dto.ProductDTO;

import edu.poly.entity.Product;

@Component
public class ProductMapper {
	@Autowired
	private ModelMapper mapper;
	

	
	public Product convertToEntity(ProductDTO productDTO) {
		Product entity = new Product();
		mapper.map(productDTO, entity);
		return entity;
	}
	
	public ProductDTO convertToDTO(Product entity) {
		ProductDTO productDTO = new ProductDTO();
		mapper.map(entity, productDTO);
		return productDTO;
	}
}
