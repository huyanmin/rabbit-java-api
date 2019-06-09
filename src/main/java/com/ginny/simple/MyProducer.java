package com.ginny.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Harry
 * @Description //TODO
 * @Date 2019/6/716:16
 */
public class MyProducer {
    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("admin");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        // 发送消息
        String msg = "Hello world, Rabbit MQ";
        channel.basicPublish(EXCHANGE_NAME, "ginny.test", null, msg.getBytes());
        System.out.println("Had sent message to Consumer");

 /*       channel.close();
        connection.close();*/
    }
}
