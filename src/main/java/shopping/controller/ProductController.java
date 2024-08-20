package shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shopping.service.ProductService;
import shopping.domain.Product;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> createProduct(
    ) {
        return new ResponseEntity<>(productService.search(), HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> createProduct(
            @Validated @RequestBody Product product
    ) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/api/products/{id}")
    public ResponseEntity<Product> modifyProduct(
            @PathVariable("id") Long id,
            @Validated @RequestBody Product product
    ) {
        productService.update(id, product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Product> deleteProduct(
            @PathVariable("id") Long id
    ) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
