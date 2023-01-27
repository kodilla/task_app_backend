package com.crud.tasks.config;

import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TunnerRunner {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Void> executeGradleTaskAsynchronously() {
        return executor.submit(() -> {
            GradleConnector connector = GradleConnector.newConnector();
            File parentFile = new File(System.getProperty("user.dir"));
            connector.forProjectDirectory(parentFile);
            try (ProjectConnection connection = connector.connect()) {
                connection.newBuild().forTasks("tunnel").run();
            }
            return null;
        });
    }
}