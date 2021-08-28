package edu.poly.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("select o from Product o where o.name like ?1")
	Page<Product> findByKeyWords(String keywords, Pageable pageable);
	
	@Query("select o from Product o where o.id =:id ")
	public Product findIdProduct(@Param("id") Integer id);
	
	@Query("select o from Product o where o.name like ?1")
	List<Product> findByKeyWord(String keywords);
	
	@Query("select o from Product o where o.category.id =?1 ")
	Page<Product> findByCategoryId(Integer id,  Pageable pageable);
}
