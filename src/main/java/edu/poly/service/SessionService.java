package edu.poly.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// các phương thức làm việc với attribute trong session được đặc tả trong lớp Spring Bean (SessionService)
@Service
public class SessionService {
	@Autowired
	HttpSession session;
	/*
	* Đọc giá trị của attribute trong session
	* @param name tên attribute
	* @return giá trị đọc được hoặc null nếu không tồn tại
	*/
	public <T> T get(String name) {
		return (T) session.getAttribute(name);
	}
	
	/*
	* Thay đổi hoặc tạo mới attribute trong session
	* @param name tên attribute
	* @param value giá trị attribute
	*/
	public void set(String name,Object value) {
		session.setAttribute(name, value);
	}
	
	/*
	* Xóa attribute trong session
	* @param name tên attribute cần xóa
	*/
	public void remove(String name) {
		session.removeAttribute(name);
	}
	
}
