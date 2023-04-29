# springboot-rabbitmq
复习
/**
 * 为什么使用RabbitMQ呢？因为我门代码的操作是串行的，后面的操作要等之前的操作进行完，才可以进行后续的操作
 * 但是在高并发的情况下，我么不能一直去等前面的服务，我们使用RabbitMQ中间件实现异步调用，
 * 比如用户下单后，提示下单成功，然后发一条MQ再对订单进行处理，而不是说后面的服务要等前面的服务一步步执行完
 * 提升了性能，吞吐量提高了
 */


https://www.bilibili.com/video/BV15k4y1k7Ep/?p=12&vd_source=c48b2dc0f24b9da20814bfbc345077bc
