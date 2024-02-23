package com.store.notification.component.impl;

import com.store.notification.component.RabbitMQComponent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQComponentImpl implements RabbitMQComponent {
    @Value("${rabbitmq.queue.name}")
    private String queue;

    @RabbitListener(queues = "order_notification")
    public void handleMessage(String message) {
        System.out.println(message);
    }
}
