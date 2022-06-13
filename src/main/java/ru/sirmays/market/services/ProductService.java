package ru.sirmays.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sirmays.market.model.Product;
import ru.sirmays.market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.delete(productRepository.findById(id).get());
    }

    public  List<Product> findByPriceBetween(int minPrice, int maxPrice){
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> findProductsByPriceLessThanEqual (int maxPrice){
        return productRepository.findProductsByPriceLessThanEqual(maxPrice);
    }

    public List<Product> findProductsByPriceGreaterThanEqual (int minPrice){
        return productRepository.findProductsByPriceGreaterThanEqual(minPrice);
    }

}
