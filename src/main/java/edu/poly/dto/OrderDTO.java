package edu.poly.dto;

import java.util.Date;

import edu.poly.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	private Integer id;
	
	private Account account_id;
	
	private Date createdate = new Date();
	
	private String address;
}
