package com.possystem.possystem.services.ServiceImpls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.possystem.possystem.dto.ProductDTO;
import com.possystem.possystem.entities.Product;
import com.possystem.possystem.repositories.ProductRepository;
import com.possystem.possystem.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
        .map(this::mapToDTO)
        .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductDTO> findByCode(String code) {
        Optional<Product> productOptional = productRepository.findByCode(code);
        return productOptional.map(this::mapToDTO);
    }

    @Override
    public Optional<ProductDTO> findByName(String name) {
      Optional <Product> productOptional = productRepository.findByName(name);
      return productOptional.map(this::mapToDTO);
    }

    @Override
    @Transactional
    public ProductDTO save(ProductDTO product) {
        Product productEntity = mapToEntity(product);
        productEntity = productRepository.save(productEntity);
        return mapToDTO(productEntity);
    }

    @Override
    @Transactional
    public void deleteByCode(String code) {
        productRepository.deleteByCode(code);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
            return productRepository.findAll(pageable).map(this::mapToDTO);
    }

    private ProductDTO mapToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode(product.getCode());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        return productDTO;
    }

    private Product mapToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setCode(productDTO.getCode());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        return product;
    }

}
