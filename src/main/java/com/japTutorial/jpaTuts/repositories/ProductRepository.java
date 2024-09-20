package com.japTutorial.jpaTuts.repositories;

import com.japTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findBy(Sort sortBy);
    Optional<ProductEntity> findByTitle(String title);
    Optional<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime created);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price);

    @Query("select e.title, e.price from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);


}
