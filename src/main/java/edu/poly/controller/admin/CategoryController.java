package edu.poly.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.dto.CategoryDTO;
import edu.poly.entity.Account;
import edu.poly.entity.Category;
import edu.poly.mappers.CategoryMapper;
import edu.poly.repositories.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private CategoryMapper mapper;
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/admin/category/")
	public String index(Model model) {
		List<Category> listCategory = categoryRepo.findAll();
		model.addAttribute("listCategory", listCategory);
		return "admin/crudCategory";
	}
	
	@GetMapping("/admin/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Category item = categoryRepo.findById(id).get();
		model.addAttribute("category", item);
		List<Category> listCategory = categoryRepo.findAll();
		model.addAttribute("listCategory", listCategory);
		return "admin/crudCategory";
	}
	
	@PostMapping("/admin/category/create") 
		public String create(Category item) {
			categoryRepo.save(item);
			return "redirect:/admin/category/";
		}
	
	@RequestMapping("/admin/category/update/{id}")
	public String update(Category item) {
		categoryRepo.save(item);
		return "redirect:/admin/category/";
	}
	
	@PostMapping("/admin/category/delete/{id}")
	public String delete(@PathVariable("id") Category entity) {
			categoryRepo.delete(entity);
			return "redirect:/admin/category/";	
		
		
	}
	
	@PostMapping("/admin/category/reset")
	public String reset() {
		return "redirect:/admin/category/";
	}
	
	}
	

