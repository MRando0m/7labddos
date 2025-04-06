package com.order.io.service;

import com.order.io.config.TestcontainersConfiguration;
import com.order.io.model.entity.*;
import com.order.io.model.embeddable.Address;
import com.order.io.repository.CustomerRepository;
import com.order.io.repository.OrderRepository;
import com.order.io.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
@Transactional
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    private Order testOrder;
    private Customer testCustomer;
    private Payment testPayment;

    @BeforeEach
    @Transactional
    void setup() {
        testCustomer = new Customer();
        testCustomer.setName("Test User");
        testCustomer.setAddress(new Address("Moscow", "Tverskaya", "123456"));
        customerRepository.save(testCustomer);

        testPayment = new Credit();
        testPayment.setAmount(BigDecimal.valueOf(500.75));
        ((Credit) testPayment).setNumber("5555555555554444");
        ((Credit) testPayment).setType("MASTERCARD");
        ((Credit) testPayment).setExpDate(LocalDateTime.now().plusYears(2));
        paymentRepository.save(testPayment);

        testOrder = new Order();
        testOrder.setDate(LocalDateTime.now());
        testOrder.setStatus("PROCESSING");
        testOrder.setDeliveryAddress(new Address("Moscow", "Tverskaya", "123456"));
        testOrder.setCustomer(testCustomer);
        testPayment.setOrder(testOrder);
        testOrder.setPayment(testPayment);
        orderRepository.save(testOrder);

        orderRepository.flush();
    }

    @Test
    @Transactional
    void shouldFindOrdersByDeliveryAddress() {

        Address searchAddress = new Address("Moscow", "Tverskaya", "123456");

        List<Order> foundOrders = orderService.findOrders(
                searchAddress,
                null,
                null,
                null,
                null,
                null,
                null
        );

        assertThat(foundOrders)
                .hasSize(1)
                .first()
                .extracting(Order::getId)
                .isEqualTo(testOrder.getId());
    }

    @Test
    @Transactional
    void shouldFindOrdersByTimeInterval() {
        List<Order> foundOrders = orderService.findOrders(
                null,
                LocalDateTime.now().minusHours(1),
                LocalDateTime.now().plusHours(1),
                null,
                null,
                null,
                null
        );

        assertThat(foundOrders)
                .extracting(Order::getId)
                .contains(testOrder.getId());
    }

    @Test
    @Transactional
    void shouldFindOrdersByPaymentType() {
        List<Order> foundOrders = orderService.findOrders(
                null,
                null,
                null,
                "CREDIT",
                null,
                null,
                null
        );

        assertThat(foundOrders)
                .extracting(Order::getId)
                .contains(testOrder.getId());
    }

    @Test
    void shouldFindOrdersByCustomerName() {
        List<Order> foundOrders = orderService.findOrders(
                null,
                null,
                null,
                null,
                "Test User",
                null,
                null
        );

        assertThat(foundOrders)
                .extracting(Order::getCustomer)
                .extracting(Customer::getId)
                .contains(testCustomer.getId());
    }
}