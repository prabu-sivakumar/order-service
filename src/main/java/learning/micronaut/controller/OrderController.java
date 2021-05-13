package learning.micronaut.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import learning.micronaut.model.Order;
import learning.micronaut.service.OrderService;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Controller("/order")
public class OrderController {

    @Inject
    private OrderService orderService;

    @Get("/")
    public Collection<Order> getOrders() {
        return orderService.getOrders();
    }

    @Post("/")
    public Order add(@NotNull Long id, @NotBlank String product, @Min(1) Integer quantity, Double price) {
        Order order = new Order(id, product, quantity, price);
        orderService.addOrder(order);
        return order;
    }
}