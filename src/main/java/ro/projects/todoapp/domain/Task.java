package ro.projects.todoapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Task {

    private String userId;
    private String name;
    private String description;
    private LocalDate deadLine;
    private Boolean isDone;

}
