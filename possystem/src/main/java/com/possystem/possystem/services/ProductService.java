package com.possystem.possystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.possystem.possystem.dto.ProductDTO;

public interface ProductService {

        List<ProductDTO> findAll();

        Optional<ProductDTO> findByName(String name);

        Optional<ProductDTO> findByCode(String code);

        ProductDTO save (ProductDTO product);

        void deleteByCode(String code);

        Page<ProductDTO> findAll(Pageable pageable);

}
