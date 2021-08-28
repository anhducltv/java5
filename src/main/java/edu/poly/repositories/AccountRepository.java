package edu.poly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query("select entity from Account entity where email =:email")
	public Account findByEmail(@Param("email") String email);
}
