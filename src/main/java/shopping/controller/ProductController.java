package shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shopping.service.ProductService;
import shopping.domain.Product;

import java.util.Map;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public Map<Long, Product> createProduct(
    ) {
        return productService.search();
    }

    @PostMapping("/api/products")
    public void createProduct(
            @Validated @RequestBody Product product
    ) {
        productService.save(product);
    }

    @PutMapping("/api/products/{id}")
    public void modifyProduct(
            @PathVariable("id") Long id,
            @Validated @RequestBody Product product
    ) {
        productService.update(id, product);
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProduct(
            @PathVariable("id") Long id
    ) {
        productService.delete(id);
    }
}
