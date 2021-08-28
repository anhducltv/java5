package edu.poly.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import edu.poly.dto.CategoryDTO;

import edu.poly.entity.Category;

@Component
public class CategoryMapper {
	@Autowired
	private ModelMapper mapper;
	

	
	public Category convertToEntity(CategoryDTO categoryDTO) {
		Category entity = new Category();
		mapper.map(categoryDTO, entity);
		return entity;
	}
	
	public CategoryDTO convertToDTO(Category entity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		mapper.map(entity, categoryDTO);
		return categoryDTO;
	}
}
