package edu.poly.dto;

import javax.validation.constraints.NotNull;

import edu.poly.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class CartDTO {

	@NotNull
 private Integer id;
	
	@NotNull
	private Account account;
}
