package edu.poly.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import edu.poly.dto.AccountDTO;
import edu.poly.entity.Account;

@Component
public class AccountMapper {
	@Autowired
	private ModelMapper mapper;
	

	
	public Account convertToEntity(AccountDTO accountDTO) {
		Account entity = new Account();
		mapper.map(accountDTO, entity);
		return entity;
	}
	
	public AccountDTO convertToDTO(Account entity) {
		AccountDTO accountDTO = new AccountDTO();
		mapper.map(entity, accountDTO);
		return accountDTO;
	}
}
