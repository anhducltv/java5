package edu.poly.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.libs.HashUtil;
import edu.poly.mappers.AccountMapper;
import edu.poly.mappers.CartMapper;
import edu.poly.dto.AccountDTO;
import edu.poly.dto.CartDTO;
import edu.poly.entity.Account;
import edu.poly.entity.Cart;
import edu.poly.repositories.AccountRepository;
import edu.poly.repositories.CartRepository;

@Controller
public class LoginController {
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	AccountMapper mapper;
	@Autowired
	CartMapper cartMapper;
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		Account entity = this.accountRepo.findByEmail(email);
		boolean checkPw = false;
		if(entity!=null) {
			checkPw = HashUtil.verify(password, entity.getPassword());
		}
		if(entity==null || !checkPw) {
			request.getSession().setAttribute("error_message", "Sai email hoặc password");
			return "redirect:/login";
		}
		
		if(entity.getActivated()==0) {
			request.getSession().setAttribute("error_message", "Tài khoản của bạn đã bị khóa vĩnh viễn do vi phạm nội quy người dùng. Liên hệ ban quản trị để biết thêm chi tiết.");
			return "redirect:/login";
		}
		
		request.getSession().setAttribute("account", entity);
		request.getSession().setAttribute("isLogin", true);
		request.getSession().setAttribute("role", entity.getAdmin());
		request.getSession().setAttribute("fullname", entity.getFullname());
	
		return "redirect:/admin/users/";
	}
	
	@GetMapping("/signup")
	public String getFormSignup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(Model model, @Valid  AccountDTO account,@Valid CartDTO cart ,BindingResult result) {
		//kiểm lỗi nhập
		Account entity = mapper.convertToEntity(account);
		String hashedPwd = HashUtil.hash(account.getPassword());
		entity.setPassword(hashedPwd);
		this.accountRepo.save(entity);
		
		Cart entity1 = cartMapper.convertToEntity(cart);
		entity1.setAccount(entity);
		this.cartRepo.save(entity1);
		
		request.getSession().setAttribute("message", "Đăng ký thành công !");
		return "redirect:/signup";	
		}
}
