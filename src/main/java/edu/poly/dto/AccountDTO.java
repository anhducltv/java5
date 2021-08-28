package edu.poly.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import edu.poly.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class AccountDTO {
	
	private Integer id;
	
	@NotNull(message = "Họ tên không để trống !")
	@NotBlank
	private String fullname;
	
	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@NotBlank
	private String password;
	
	private String photo;
	
	@NotNull
	private Integer activated = 1;
	
	@NotNull
	private Integer admin=0;
	
	private Cart cart;
	
}
