package shopping.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.ProductValidator;
import shopping.domain.Product;
import shopping.repository.ProductRepository;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductValidator validator;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductValidator validator) {
        this.productRepository = productRepository;
        this.validator = validator;
    }

    public Product save(Product product) {
        validator.isOverLimitLength(product.getName());
        return productRepository.save(product);
    }

    public List<Product> search() {
        return productRepository.findAll();
    }


    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void update(Long id, Product product) {
        Product findProduct = productRepository.findById(id).orElseThrow();

        if (findProduct != null) {
            validator.isOverLimitLength(product.getName());
        }

        findProduct.update(product);

        productRepository.save(findProduct);
    }
}
