package com.example.r2dbc_pagination.Service;


import com.example.r2dbc_pagination.Model.Product;
import com.example.r2dbc_pagination.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class ProductService {

    @Autowired(required = false)
    private ProductRepository repository;

   /* public Mono<Page<Product>> getProducts(PageRequest pageRequest){
        return this.repository.findAllBy(pageRequest)
                .collectList()
                .zipWith(repository.count())
                        .map(t -> new PageImpl<>(t.getT1(), (Pageable) pageRequest, (Long) t.getT2()));
    }*/


    public Mono<Page<Product>> getProducts (PageRequest pageRequest){
        return this.repository.findAllBy(pageRequest)
                .collectList()
                .zipWith(this.repository.count())
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
    }


}
