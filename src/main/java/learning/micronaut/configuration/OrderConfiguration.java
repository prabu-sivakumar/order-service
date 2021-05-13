package learning.micronaut.configuration;

import io.micronaut.context.annotation.EachProperty;
import learning.micronaut.model.Order;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@EachProperty("orders")
public class OrderConfiguration {

    private Long id;
    private String product;
    private Integer quantity;

    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order create() {
        return new Order(id, product, quantity, price);
    }
}
