package dev.kovalevna.processor.service;

import dev.kovalevna.processor.dto.TaskDto;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);
    TaskDto getTaskById(int id);
}
