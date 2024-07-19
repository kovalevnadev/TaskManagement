package dev.kovalevna.processor.mapper;

import dev.kovalevna.jooq.tables.records.TasksRecord;
import dev.kovalevna.processor.dto.TaskDto;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements RecordMapper<TasksRecord, TaskDto> {
    @Override
    public TaskDto map(TasksRecord tasksRecord) {
        return new TaskDto(tasksRecord.getId(), tasksRecord.getName(), tasksRecord.getNotes());
    }
}
