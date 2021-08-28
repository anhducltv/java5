package edu.poly.controller.admin;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.dto.ProductDTO;
import edu.poly.entity.Category;
import edu.poly.entity.Product;
import edu.poly.mappers.ProductMapper;
import edu.poly.repositories.CategoryRepository;
import edu.poly.repositories.ProductRepository;
import edu.poly.service.ParamService;
import edu.poly.service.SessionService;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	ProductMapper mapper;
	@Autowired
	SessionService session;
	@Autowired
	ServletContext application;
	@Autowired
	ParamService paramService;
	
	@RequestMapping("/logout")
	public String logout() {
	session.remove("account");
	return "redirect:/login";
	}
	
//	@GetMapping("/admin/product/")
//	public String index(Model model) {
//		List<Product> listProduct = productRepo.findAll();
//		model.addAttribute("listProduct", listProduct);
//		return "admin/crudProduct";
//	}
	@GetMapping("/admin/product")
	public String search(Model model, 
			@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> listProduct = productRepo.findAll(pageable);
		model.addAttribute("listProduct", listProduct);
		return "admin/crudProduct";
	}
	
	@PostMapping("/admin/product")
	public String search(Model model, @RequestParam("tensp") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(session.get("tensp"));
		session.set("tensp", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> listProduct = productRepo.findByKeyWords("%" + kwords + "%", pageable);
		model.addAttribute("listProduct", listProduct);
		return "admin/crudProduct";
	}
	
	@GetMapping("/admin/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Product entity, 
			@RequestParam("p") Optional<Integer> p) {
		ProductDTO productDTO = mapper.convertToDTO(entity);
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
	//	Product item = productRepo.findById(id).get();
		model.addAttribute("product", productDTO);
		Page<Product> listProduct = productRepo.findAll(pageable);
		model.addAttribute("listProduct", listProduct);
		return "admin/crudProduct";
	}
	
	@PostMapping("/admin/product/create") 
	public String create(@Valid @ModelAttribute("product") ProductDTO product) {
		if(!product.getImageFile().isEmpty()) {
			String path = application.getRealPath("/");
			System.out.println("path:" +path);
			try {
				product.setImage(product.getImageFile().getOriginalFilename());
				String filePath = path + "/images/" + product.getImage();
				product.getImageFile().transferTo(Path.of(filePath));
			//	product.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Product entity = mapper.convertToEntity(product);
		this.productRepo.save(entity);
		return "redirect:/admin/product/";
	}
	
	@PostMapping("/admin/product/update/{id}")
	public String update(Model model,  @ModelAttribute("product") ProductDTO product,BindingResult result) {
//		if(result.hasErrors()) {
//			List<ObjectError> errors = result.getAllErrors();
//			System.out.println("true " +errors.get(0).getDefaultMessage());
//			model.addAttribute("errors", errors);
//			return "admin/users/edit";
//		} else {
		if(!product.getImageFile().isEmpty()) {
			String path = application.getRealPath("/");
			System.out.println("path:" +path);
			try {
				product.setImage(product.getImageFile().getOriginalFilename());
				String filePath = path + "/images/" + product.getImage();
				product.getImageFile().transferTo(Path.of(filePath));
				product.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			Product entity = mapper.convertToEntity(product);
			this.productRepo.save(entity);
			return "redirect:/admin/product/";
		}	
	
	@PostMapping("/admin/product/delete/{id}")
	public String delete(@PathVariable("id") Product entity) {
		productRepo.delete(entity);
		return "redirect:/admin/product/";
	}
	
	@PostMapping("/admin/product/reset")
	public String reset() {
		return "redirect:/admin/product/";
	}
	
	
	
	@ModelAttribute("danhmuc")
	public List<Category> getCategory() {	
		List<Category> list = categoryRepo.findAll();
		return list;
	}

}
