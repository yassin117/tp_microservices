package com.yassine.product.service;

import com.yassine.product.dto.ProductRequest;
import com.yassine.product.dto.ProductResponse;

import java.util.List;

public interface ProductService  {


    public void createProduct(ProductRequest productRequest);

    public List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);  

    public void updateProduct(Long id, ProductRequest productRequest);

    public void deleteProduct(Long id);

}
