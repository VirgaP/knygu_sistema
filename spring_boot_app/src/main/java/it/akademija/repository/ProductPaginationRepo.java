package it.akademija.repository;

import it.akademija.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPaginationRepo extends PagingAndSortingRepository<ProductEntity, Long>{
    public Page findAll(Pageable pageable);
}
