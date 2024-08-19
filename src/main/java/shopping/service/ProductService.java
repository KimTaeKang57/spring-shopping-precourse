package shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    private final Map<Long, Product> products = new HashMap<>();
    private final AtomicLong idCount = new AtomicLong();

    public void save(Product product) {
        Long id = idCount.getAndIncrement();

        Product product1 = new Product(id, product);

        products.put(product1.getId(), product1);
    }

    public Map<Long, Product> search() {
        return products;
    }

    public void delete(Long id) {
        products.remove(id);
    }

    public void update(Long id, Product product) {
        Product product1 = products.get(id);

        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setImageUrl(product.getImageUrl());
    }
}
