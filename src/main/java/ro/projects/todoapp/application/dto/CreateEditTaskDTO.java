package ro.projects.todoapp.application.dto;

import lombok.Getter;

@Getter
public class CreateEditTaskDTO {
    private String userId;
    private String name;
    private String description;
    private String deadLine;
    private Boolean isDone;
}
