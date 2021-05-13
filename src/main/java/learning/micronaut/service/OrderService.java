package learning.micronaut.service;

import learning.micronaut.configuration.OrderConfiguration;
import learning.micronaut.model.Order;

import javax.inject.Singleton;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

@Singleton
public class OrderService {

    private final Collection<Order> orders = new ConcurrentLinkedDeque<>();

    public OrderService(List<OrderConfiguration> orderConfigurations) {
        for (OrderConfiguration configuration : orderConfigurations) {
            Order order = configuration.create();
            orders.add(order);
        }
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

}