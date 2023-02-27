package com.example.tp_spring.repository;

        import com.example.tp_spring.modele.Product;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Find products by name
    List<Product> findByName(String name);

    //Find products by name containing a certain string
    List<Product> findByNameContaining(String name);

    //delete a product
    void deleteById(Long id);

    //Add a new product
    Product save(Product product);





}
