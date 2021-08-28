package edu.poly.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.dto.AccountDTO;
import edu.poly.entity.Account;
import edu.poly.libs.HashUtil;

import edu.poly.dto.AccountDTO;
import edu.poly.entity.Account;
import edu.poly.mappers.AccountMapper;
import edu.poly.repositories.AccountRepository;

@Controller
//@RequestMapping("/admin/users")
public class AccountController {
	@Autowired
	private AccountRepository accountRepo;
	@Autowired 
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	private AccountMapper mapper;

	
	@GetMapping("/admin/users/")
	public String user(Model model) {
		List<Account> listAccount = accountRepo.findAll();
		model.addAttribute("listAccount", listAccount);
	return "admin/crudUser";
	}
	
//	@RequestMapping("/admin/users/edit/{id}")
//	public String edit(Model model,@PathVariable("id") Account entity ) {
//		 System.out.println("edit !");
//		AccountDTO accountDTO = mapper.convertToDTO(entity);
//		model.addAttribute("account", accountDTO);
//		return "admin/crudUser";
//	}
	
	@RequestMapping("/admin/users/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Account item = accountRepo.findById(id).get();
		model.addAttribute("acc", item);
		List<Account> listAccount = accountRepo.findAll();
		model.addAttribute("listAccount", listAccount);
		return "admin/crudUser";
	}
	
	@RequestMapping("/admin/users/update/{id}")
	public String update(Account item) {
		accountRepo.save(item);
		return "redirect:/admin/users/";
	}

	
	@PostMapping("/admin/users/delete/{id}")
	public String delete(@PathVariable("id") Account entity) {
		this.accountRepo.delete(entity);
		return "redirect:/admin/users/";
	}

	
}
