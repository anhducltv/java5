package edu.poly.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import edu.poly.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class ProductDTO {
	private Integer id;
	
	private String name;
	
	private String image;
	private MultipartFile imageFile;
	private Integer price;
	
	private Date createdate = new Date();
	
	private Integer available;
	
	@NotNull(message = "Không để trống id_category")
	private Category category;
}
