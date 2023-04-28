package com.hollow.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘继涛
 * @version 1.0
 * 这里演示的是topic类型的mq,还有许多其他类型的工作模式,并且交换机和队列的参数也有许多
 */

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "boot_topic_exchange";
    public static final String QUEUE_NAME = "boot_queue";
    //1.交换机
    @Bean("bootExchange")
    public Exchange bootExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME) //名字
                .durable(true) //持久化
                .build(); //构建
    }
    //2.队列

    @Bean("bootQueue")
    public Queue bootQueue(){
        return QueueBuilder.durable(QUEUE_NAME) //名字
                .build(); //构建
    }

    //3.队列和交换机绑定关系 Binding
    /**
     * 1.知道那个队列
     * 2.知道那个交换机
     * 3.routing key
     */

    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange")Exchange exchange){
        return BindingBuilder.bind(queue)//队列
                .to(exchange)//交换机
                .with("boot.#")//routing key
                .noargs();//额外参数
    }

}
