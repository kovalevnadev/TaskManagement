package dev.kovalevna.processor.integration.audit;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuditKafkaProducer {

    private final KafkaTemplate<String, String> auditKafkaTemplate;

    public AuditKafkaProducer(KafkaTemplate<String, String> auditKafkaTemplate) {
        this.auditKafkaTemplate = auditKafkaTemplate;
    }

    public void sendAuditMessage(String message) {
        auditKafkaTemplate.send("task_audit_topic", message);
    }
}
