package edu.poly.controller.admin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import edu.poly.entity.Account;
import edu.poly.entity.Product;
import edu.poly.service.ShoppingCartService;

@SessionScope
@Service
public class ShoppingCartImplement implements ShoppingCartService {
	Map<Integer, Product> map = new HashMap<>();
	// thêm vào giỏ hàng thì dựa vào mã sp(id)
	@Override
	public Product add(Integer id) {
		//kiểm tra id có trong giỏ hàng chưa
		Product item = map.get(id);
		if(item==null) {
			//lấy 1 món hàng
			//item = DB.items.get(id);
			item = map.get(id);
			//item.setQty(1);
			map.put(id, item);
		} else {
		//	item.setQty(item.getQty() +1);
		}
		return item;
	}
	
	
	@Override
	public void remove(Integer id) {
		//xóa 1 món hàng dựa vào mã sp(id)
		map.remove(id);
		
	}
	@Override
	public Product update(Integer id, int qty) {
		//cập nhật số lượng cho id nào
		Product item = map.get(id);
	//	item.setQty(qty);
		return item;
	}
	
	@Override
	public void clear() {
		//xóa sạch giỏ hàng
		map.clear();	
	}
	
	@Override
	public Collection<Product> getItems() {
		// lấy danh sách tất cả các món hàng
		return map.values();
		
	}
	@Override
	public int getCount() {
		// tổng sl những món hàng đã chọn
	//	return map.values().stream().mapToInt(item -> item.getQty()).sum();
		return 1;
	}
	
	@Override
	public double getAmount() {
		// tổng tiền
	//	return map.values().stream().mapToDouble(item -> item.getPrice()*item.getQty()).sum();
		return 1;
	}
}
