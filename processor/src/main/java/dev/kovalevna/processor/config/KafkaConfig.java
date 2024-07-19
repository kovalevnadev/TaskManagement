package dev.kovalevna.processor.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic auditTopic() {
        return new NewTopic("task_audit_topic", 1, (short) 1);
    }
}
