package com.example.tp_spring.service;

import com.example.tp_spring.modele.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tp_spring.repository.ProductRepository;


import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    // Méthode pour récupérer tous les produits
    public List<Product> listsAll() {

        return productRepository.findAll();
    }

    // Méthode pour sauvegarder un produit
    public void save(Product product) {
        productRepository.save(product);
    }

    // Méthode pour récupérer un produit par son id
    public Product get(Long id) {

        return productRepository.findById(id).get();
    }

    // Méthode pour supprimer un produit par son id
    public void delete(Long id) {
        productRepository.deleteById(id);
    }


    public List<Product> getProductsContainingName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public void update(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product id: " + id));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }
}