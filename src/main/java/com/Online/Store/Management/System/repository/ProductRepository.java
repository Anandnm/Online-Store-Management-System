package com.Online.Store.Management.System.repository;

import com.Online.Store.Management.System.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
