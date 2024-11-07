package com.yassine.product.service;

import com.yassine.product.dto.ProductRequest;
import com.yassine.product.dto.ProductResponse;
import com.yassine.product.model.Product;
import com.yassine.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName())
                .weight(productRequest.getWeight()).build();
        productRepository.save(product);
        log.info("product {} is saved",product.getId());

    }

    public List<ProductResponse> getAllProducts(){
       List<Product> products =  productRepository.findAll();
       return products.stream().map(product -> mapToProductResponse(product)).toList();

    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));

        // Convert the Product entity to ProductResponse DTO
        return new ProductResponse(product.getId(), product.getName(), product.getWeight());
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder().id(product.getId()).name(product.getName()).weight(product.getWeight()).build();
    }

    public void updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));

        product.setName(productRequest.getName());
        product.setWeight(productRequest.getWeight());

        productRepository.save(product);
        log.info("Product {} is updated", product.getId());
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));

        productRepository.delete(product);
        log.info("Product {} is deleted", product.getId());
    }



    
}
