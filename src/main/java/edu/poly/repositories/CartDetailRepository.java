package edu.poly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.entity.Cartdetail;

@Repository
public interface CartDetailRepository extends JpaRepository<Cartdetail, Integer> {
 @Query("select o from Cartdetail o where o.product.id =:id ")
 public Cartdetail findCartDetailByIdProduct(@Param("id") Integer id);
 
 @Query("select o from Cartdetail o where o.cart.id=:id ")
 List<Cartdetail> findCartDetailByIdCart(@Param("id") Integer id);
}
