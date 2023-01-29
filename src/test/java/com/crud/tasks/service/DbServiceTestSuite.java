package com.crud.tasks.service;


import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(MockitoExtension.class)
public class DbServiceTestSuite {

    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void testGetAllTasks() {
        List<Task> listOfTasks = new ArrayList<>();
        listOfTasks.add(new Task(1L, "sprzatanie", "mycie kafelków"));
        when(dbService.getAllTasks()).thenReturn(listOfTasks);
        List<Task> resultList = dbService.getAllTasks();
        assertEquals(1, resultList.size());
    }

    @Test
    public void saveTask() {
        Task task = new Task(1L, "sprzatanie", "mycie kafelków");
        when(dbService.saveTask(task)).thenReturn(task);
        Task result = dbService.saveTask(task);
        assertEquals("sprzatanie", result.getTitle());
    }

    @Test
    public void testGetTaskById() {
        Task task = new Task(1L, "sprzatanie", "mycie kafelków");
        when(dbService.getTaskById(task.getId())).thenReturn(Optional.ofNullable(task));
        Optional<Task> result = dbService.getTaskById(task.getId());
        assertTrue("optional żyje", result.isPresent());
    }

    @Test
    public void testDeleteTaskById() {
        Task task = new Task(1L, "sprzatanie", "mycie kafelków");
        dbService.deleteTaskById(task.getId());
        verify(taskRepository, atLeastOnce()).deleteById(anyLong());
    }

}
