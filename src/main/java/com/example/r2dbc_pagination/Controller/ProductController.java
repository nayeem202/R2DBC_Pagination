package com.example.r2dbc_pagination.Controller;

import com.example.r2dbc_pagination.Model.Product;
import com.example.r2dbc_pagination.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("all")
    public Mono<Page<Product>> getAll(@RequestParam("page") int page, @RequestParam("size") int size){
        return this.productService.getProducts(PageRequest.of(page, size));
    }
}
