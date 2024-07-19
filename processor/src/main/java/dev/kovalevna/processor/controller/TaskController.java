package dev.kovalevna.processor.controller;

import dev.kovalevna.processor.dto.TaskDto;
import dev.kovalevna.processor.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable int id) {
        logger.info("> Start getTaskById request with id = {}", id);
        TaskDto response = taskService.getTaskById(id);
        logger.info("< End getTaskById request with id = {} response = {}", id, response);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto task) {
        return ResponseEntity.ok(taskService.addTask(task));
    }
}
