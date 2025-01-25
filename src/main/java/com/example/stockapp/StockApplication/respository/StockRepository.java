package com.example.stockapp.StockApplication.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockapp.StockApplication.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}


