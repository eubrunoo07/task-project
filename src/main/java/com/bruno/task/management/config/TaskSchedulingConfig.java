package com.bruno.task.management.config;

import com.bruno.task.management.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class TaskSchedulingConfig {
    @Autowired
    private TaskService taskService;

    @Scheduled(cron = "0 0 0 * * *")
    public void updateExpiredTaskStatus() {
        taskService.updateStatusOfExpiredTasks();
    }
}
