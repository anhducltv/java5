package edu.poly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
