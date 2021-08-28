package edu.poly.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.entity.Order;
import edu.poly.repositories.OrderRepository;

@Controller
public class OrderController {
	@Autowired
	OrderRepository orderRepo;
	
	@RequestMapping("/admin/order/")
	public String index(Model model) {
		List<Order> listOrder = orderRepo.findAll();
		model.addAttribute("listOrder", listOrder);
		return "admin/order";
	}
}
