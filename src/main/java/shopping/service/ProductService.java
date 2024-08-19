package shopping.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.domain.Product;
import shopping.repository.ProductRepository;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> search() {
        return productRepository.findAll();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, Product product) {
        Product findProduct = productRepository.findById(id).orElse(null);

        findProduct.update(product);

        productRepository.save(findProduct);
    }
}
