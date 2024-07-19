package dev.kovalevna.audit.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "task_audit_topic", groupId = "audit_consumer")
    public void listen(ConsumerRecord<String, String> auditIncomeMessage) {
        System.out.println("Received message: " + auditIncomeMessage.value());
    }
}
