package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TaskMapperTestSuite {

    @Autowired
    TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        TaskDto taskDto = new TaskDto(2L, "tytul", "cos_tam");
        Task result = taskMapper.mapToTask(taskDto);
        assertEquals("tytul", result.getTitle());
    }

    @Test
    public void testMapToTaskDto() {
        Task task = new Task(2L, "tytul", "cos_tam");
        TaskDto result = taskMapper.mapToTaskDto(task);
        assertEquals("tytul", result.getTitle());
    }

    @Test
    public void testMapToTaskDtoList() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(2L, "tytul", "cos_tam"));
        List<TaskDto> result = taskMapper.mapToTaskDtoList(taskList);
        assertEquals(1, result.size());
    }
}
