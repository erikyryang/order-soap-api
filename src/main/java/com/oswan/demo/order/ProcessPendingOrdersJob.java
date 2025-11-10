package com.oswan.demo.order;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProcessPendingOrdersJob  implements Job {
    private static final Logger logger = LoggerFactory.getLogger(ProcessPendingOrdersJob.class);

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void execute(JobExecutionContext context) {
        logger.info("Running ProcessPendingOrdersJob");
        orderRepository.findAll().stream()
            .filter(order -> "RECEIVED".equals(order.getStatus()))
            .forEach(order -> {
                order.setStatus("PROCESSED");
                orderRepository.save(order);
                logger.info("Processed order ID: {}", order.getId());
            });
    }
}
