package com.Online.Store.Management.System.service.impl;

import com.Online.Store.Management.System.entity.Product;
import com.Online.Store.Management.System.exception.ResourceNotFondException;
import com.Online.Store.Management.System.payload.ProductDto;
import com.Online.Store.Management.System.repository.ProductRepository;
import com.Online.Store.Management.System.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        Product save = productRepository.save(product);

        ProductDto dto = new ProductDto();
        dto.setId(save.getId());
        dto.setName(save.getName());
        dto.setPrice(save.getPrice());
        return dto;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> collect = products.stream().map(product -> mapToDto(product)).collect(Collectors.toList());
        return collect;

    }

    @Override
    public ProductDto getProductByID(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFondException("Product Not Found By Id" + id));
        return mapToDto(product);
    }

    @Override
    public ProductDto updateProduct(long id, ProductDto productDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFondException("Product Not Found By Id" + id));
        Product products = mapToEntity(productDto);
        products.setId(id);
        Product save = productRepository.save(products);
        ProductDto dto = mapToDto(save);
        return dto;
    }

    @Override
    public void deleteProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFondException("Product Not Found By Id" + id));
        productRepository.deleteById(id);
    }


    ProductDto mapToDto(Product product) {
        ProductDto map = modelMapper.map(product, ProductDto.class);
        return map;
    }

    Product mapToEntity(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }
}

