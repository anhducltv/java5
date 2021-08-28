package edu.poly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.poly.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	@Query("select distinct o.name from Category o")
	List<Category> getNameCategory();
}
