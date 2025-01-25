package com.example.stockapp.StockApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockapp.StockApplication.model.Stock;
import com.example.stockapp.StockApplication.respository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    public Stock updateStock(Long id, Stock stockDetails) {
        return stockRepository.findById(id).map(stock -> {
            stock.setName(stockDetails.getName());
            stock.setQuantity(stockDetails.getQuantity());
            stock.setPrice(stockDetails.getPrice());
            return stockRepository.save(stock);
        }).orElseThrow(() -> new RuntimeException("Stock not found with id: " + id));
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
