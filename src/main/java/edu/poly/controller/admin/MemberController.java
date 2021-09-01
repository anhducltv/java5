package edu.poly.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import edu.poly.dto.CartDetailDTO;
import edu.poly.dto.OrderDTO;
import edu.poly.dto.OrderdetailDTO;
import edu.poly.dto.ProductDTO;
import edu.poly.entity.Account;
import edu.poly.entity.Cart;
import edu.poly.entity.Cartdetail;
import edu.poly.entity.Category;
import edu.poly.entity.Order;
import edu.poly.entity.OrderDetail;
import edu.poly.entity.Product;
import edu.poly.mappers.CartDetailMapper;
import edu.poly.mappers.OrderDetailMapper;
import edu.poly.mappers.OrderMapper;
import edu.poly.mappers.ProductMapper;
import edu.poly.repositories.CartDetailRepository;
import edu.poly.repositories.CartRepository;
import edu.poly.repositories.CategoryRepository;
import edu.poly.repositories.OrderDetailRepository;
import edu.poly.repositories.OrderRepository;
import edu.poly.repositories.ProductRepository;
import edu.poly.service.SessionService;
import edu.poly.service.ShoppingCartService;

@Controller
//@RequestMapping("member")
public class MemberController {
	@Autowired
	ProductRepository productRepo;
	@Autowired
	HttpServletRequest request;
	@Autowired
	SessionService session;
	@Autowired
	ProductMapper mapper;
	@Autowired
	ShoppingCartService cart;
	@Autowired
	CartRepository cartRepo;
	@Autowired
	CartDetailRepository cartdetailRepo;
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	OrderDetailRepository orderdetailRepo;
	@Autowired
	OrderDetailMapper orderdetailMapper;
	@Autowired
	CartDetailMapper cartdetailMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	CategoryRepository categoryRepo;

	@GetMapping("/member/search-and-page")
	public String home(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 12);
		Page<Product> listProduct = productRepo.findAll(pageable);
		model.addAttribute("listProduct", listProduct);
		return "admin/member";
	}

	@PostMapping("/member/search-and-page")
	public String search(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse("");
		// session.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0), 12);
		Page<Product> listProduct = productRepo.findByKeyWords("%" + kwords + "%", pageable);
		model.addAttribute("listProduct", listProduct);
		return "admin/member";

	}

	@ModelAttribute("danhmucSP")
	public List<Category> getCategory() {
		List<Category> list = categoryRepo.findAll();
		return list;
	}

	@GetMapping("/member/viewdetail/{id}")
	public String viewDetail(Model model, @PathVariable("id") Integer id) {
		Product product = productRepo.getById(id);
		model.addAttribute("infoProduct", product);
		return "admin/detailProduct";
	}

	@RequestMapping("/member/add/{id}")
	public String add(@PathVariable("id") Product product, Model model) {
		Account account = (Account) request.getSession().getAttribute("account");
		Cart cart = this.cartRepo.findByIdAccount(account.getId());
		if (cartdetailRepo.findCartDetailByIdProduct(product.getId()) == null) {
			Cartdetail cartdetail = new Cartdetail();
			String time = java.time.LocalDateTime.now() + "";
			cartdetail.setCart(cart);
			cartdetail.setProduct(product);
			cartdetail.setCreatedate(time);
			cartdetail.setQuantity(1);
			this.cartdetailRepo.save(cartdetail);
		} else {
			Cartdetail find = cartdetailRepo.findCartDetailByIdProduct(product.getId());
			find.setQuantity(find.getQuantity() + 1);
			this.cartdetailRepo.save(find);
		}
		request.getSession().setAttribute("messageCart", "Đã thêm sản phẩm vào giỏ hàng !");
		return "redirect:/member/search-and-page";
	}

	@RequestMapping("/member/viewCart/")
	public String viewCart(Model model) {
		Account account = (Account) request.getSession().getAttribute("account");
		Cart cart = this.cartRepo.findByIdAccount(account.getId());
		List<Cartdetail> list = cartdetailRepo.findCartDetailByIdCart(cart.getId());
		model.addAttribute("listCart", list);
		int tongtien = 0;
		for (int i = 0; i < list.size(); i++) {
			tongtien = tongtien + (list.get(i).getQuantity() * list.get(i).getProduct().getPrice());
		}
		model.addAttribute("tongtien", tongtien);
		return "admin/myCart";
	}

	@GetMapping("/member/delete/{id}")
	public String deleteSpInCart(@PathVariable("id") Integer id) {
		cartdetailRepo.deleteById(id);
		return "redirect:/member/viewCart/";
	}

	@PostMapping("/member/pay")
	public String pay(Model model, @Valid OrderDTO order, @Valid OrderdetailDTO orderdetail
			) {
		Order orderEntity = orderMapper.convertToEntity(order);
		Account account = (Account) request.getSession().getAttribute("account");

//		List<Cartdetail> listCartDetailEntity = new ArrayList<Cartdetail>();
//		for (CartDetailDTO cartDetailDTO : listCartdetailDTO) {
//			listCartDetailEntity.add(cartdetailMapper.convertToEntity(cartDetailDTO));
//		}
		
		if (cartdetailRepo.count()==0) {
			request.getSession().setAttribute("messagePay", "Bạn chưa có sản phẩm nào trong giỏ hàng để thanh toán !");
		} else {

			orderEntity.setAccount(account);
			orderEntity.setAddress(request.getParameter("address"));
			orderRepo.save(orderEntity);
			
//			for (Cartdetail cartdetail : listCartDetailEntity) {
//				OrderDetail orderdetailEntity = new OrderDetail();
//				orderdetailEntity.setOrder(orderEntity);
//				orderdetailEntity.setProduct(cartdetail.getProduct());
//				orderdetailEntity.setPrice(cartdetail.getProduct().getPrice());
//				orderdetailEntity.setQuantity(cartdetail.getQuantity());
//				orderdetailRepo.save(orderdetailEntity);
//			}
			
			
			request.getSession().setAttribute("messagePay", "Thanh toán thành công !");
			cartdetailRepo.deleteAll();

		}
		return "redirect:/member/viewCart/";
	}

}
