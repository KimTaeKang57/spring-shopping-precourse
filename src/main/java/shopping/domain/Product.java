package shopping.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String imageUrl;

    protected Product() {
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void update(Product product) {
        if (product.getName() != null) {
            this.name = product.getName();
        }

        if (product.getPrice() != null) {
            this.price = product.getPrice();
        }

        if (product.getImageUrl() != null) {
            this.imageUrl = product.getImageUrl();
        }
    }
}