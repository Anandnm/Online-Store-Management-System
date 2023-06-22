package com.Online.Store.Management.System.controller;

import com.Online.Store.Management.System.payload.ProductDto;
import com.Online.Store.Management.System.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto product = productService.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        List<ProductDto> dto = productService.getAllProduct();
        return dto;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductByID(@PathVariable("id") long id){
        ProductDto dto = productService.getProductByID(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto , @PathVariable("id") long id){
        ProductDto dto = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product Deleted succefully", HttpStatus.OK);
    }
}
