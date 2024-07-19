package dev.kovalevna.processor.repository;

import dev.kovalevna.jooq.tables.records.TasksRecord;
import dev.kovalevna.processor.dto.TaskDto;
import dev.kovalevna.processor.mapper.TaskMapper;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static dev.kovalevna.jooq.tables.Tasks.TASKS;

@Repository
public class TaskRepository {

    private final DSLContext create;
    private final TaskMapper taskMapper;

    public TaskRepository(DSLContext create, TaskMapper taskMapper) {
        this.create = create;
        this.taskMapper = taskMapper;
    }

    @Transactional
    public TaskDto save(TaskDto taskDto) {
        return create.insertInto(TASKS)
                        .set(TASKS.NAME, taskDto.name())
                        .set(TASKS.NOTES, taskDto.notes())
                        .returning()
                        .fetchOne()
                        .map(record -> taskMapper.map((TasksRecord) record));
    }

    @Transactional(readOnly = true)
    public TaskDto findById(int id) {
        return create.selectFrom(TASKS)
                        .where(TASKS.ID.eq(id))
                        .fetchOne()
                        .map(record -> taskMapper.map((TasksRecord) record));
    }
}
