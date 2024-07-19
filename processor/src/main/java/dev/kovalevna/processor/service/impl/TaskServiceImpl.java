package dev.kovalevna.processor.service.impl;

import dev.kovalevna.processor.dto.TaskDto;
import dev.kovalevna.processor.integration.audit.AuditKafkaProducer;
import dev.kovalevna.processor.repository.TaskRepository;
import dev.kovalevna.processor.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final AuditKafkaProducer auditKafkaProducer;

    public TaskServiceImpl(TaskRepository taskRepository, AuditKafkaProducer auditKafkaProducer) {
        this.taskRepository = taskRepository;
        this.auditKafkaProducer = auditKafkaProducer;
    }

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        var savedTask = taskRepository.save(taskDto);
        auditKafkaProducer.sendAuditMessage(String.format("Saved new task to db with id = %s", savedTask.id()));
        return savedTask;
    }

    @Override
    public TaskDto getTaskById(int id) {
        var task = taskRepository.findById(id);
        auditKafkaProducer.sendAuditMessage(String.format("Getting task with id = %s from db", task.id()));
        return task;
    }

}
