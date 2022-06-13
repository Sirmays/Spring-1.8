package ru.sirmays.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sirmays.market.model.Product;
import ru.sirmays.market.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }


    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id).get();
    }

    @GetMapping("/products/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/products/price")
    public List<Product> findByPriceBetween(@RequestParam(name = "min") int minPrice,
                                            @RequestParam(name = "max") int maxPrice) {
        return productService.findByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/products/priceunder")
    public List<Product> findProductsByPriceLessThanEqual(@RequestParam(name = "max") int maxPrice) {
        return productService.findProductsByPriceLessThanEqual(maxPrice);
    }

    @GetMapping("/products/priceabove")
    public List<Product> findProductsByPriceGreaterThanEqual(@RequestParam(name = "min") int minPrice) {
        return productService.findProductsByPriceGreaterThanEqual(minPrice);
    }
}
