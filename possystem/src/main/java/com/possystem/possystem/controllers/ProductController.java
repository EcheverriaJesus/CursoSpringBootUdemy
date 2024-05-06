package com.possystem.possystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.possystem.possystem.dto.ProductDTO;
import com.possystem.possystem.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/search/{identifier}")
    public ResponseEntity<ProductDTO> getProductByCode(@PathVariable String identifier) {
        Optional<ProductDTO> productDTOOptionalByCode = productService.findByCode(identifier);

        if (productDTOOptionalByCode.isPresent()) {
            return ResponseEntity.ok().body(productDTOOptionalByCode.get());
        }

        Optional<ProductDTO> productDTOOptionalByName = productService.findByName(identifier);
        if (productDTOOptionalByName.isPresent()) {
            return ResponseEntity.ok().body(productDTOOptionalByName.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String code,
            @Valid @RequestBody ProductDTO productDTO) {
        Optional<ProductDTO> existingProducOptional = productService.findByCode(code);

        if (!existingProducOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ProductDTO existingProduct = existingProducOptional.get();
        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setStock(productDTO.getStock());

        ProductDTO updatedProduct = productService.save(existingProduct);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<Void> deleteProductByCode(@PathVariable String code) {
        productService.deleteByCode(code);
        return ResponseEntity.noContent().build();
    }

}
