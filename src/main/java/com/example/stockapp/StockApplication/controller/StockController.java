package com.example.stockapp.StockApplication.controller;

import com.example.stockapp.StockApplication.model.Stock;
import com.example.stockapp.StockApplication.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:5173") // Allow React frontend
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stockDetails) {
        return stockService.updateStock(id, stockDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return "Stock with ID: " + id + " has been deleted!";
    }
}
