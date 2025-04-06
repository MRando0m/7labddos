package com.order.io.service;

import com.order.io.model.entity.Order;
import com.order.io.model.embeddable.Address;
import com.order.io.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> findOrders(
            Address deliveryAddress,
            LocalDateTime startDate,
            LocalDateTime endDate,
            String paymentType,
            String customerName,
            String orderStatus,
            Boolean paymentStatus
    ) {
        Specification<Order> spec = Specification.where(null);

        // Адрес доставки
        if (deliveryAddress != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("deliveryAddress"), deliveryAddress));
        }

        // Временной интервал
        if (startDate != null && endDate != null) {
            spec = spec.and((root, query, cb) ->
                    cb.between(root.get("date"), startDate, endDate));
        }

        // Способ оплаты
        if (paymentType != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("payment").type().as(String.class), paymentType));
        }

        // Имя клиента
        if (customerName != null) {
            spec = spec.and((root, query, cb) ->
                    cb.like(root.get("customer").get("name"), "%" + customerName + "%"));
        }

        // Статус заказа
        if (orderStatus != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("status"), orderStatus));
        }

        // Статус оплаты
        if (paymentStatus != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("payment").get("paid"), paymentStatus));
        }

        return orderRepository.findAll(spec);
    }
}