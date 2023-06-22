package com.Online.Store.Management.System.service;

import com.Online.Store.Management.System.payload.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProduct();

    ProductDto getProductByID(long id);


    ProductDto updateProduct(long id, ProductDto productDto);

    void deleteProduct(long id);
}
