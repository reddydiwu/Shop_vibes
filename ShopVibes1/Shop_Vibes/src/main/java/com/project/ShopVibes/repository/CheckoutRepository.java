package com.project.ShopVibes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ShopVibes.model.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Integer>{

}
