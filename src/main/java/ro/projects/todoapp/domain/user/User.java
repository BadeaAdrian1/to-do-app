package ro.projects.todoapp.domain.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.projects.todoapp.domain.Task;

import java.time.LocalDate;
import java.util.List;

@Document
@AllArgsConstructor
@Getter
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDate joinDate;
    private List<Task> taskList;


    public void update(
            final String newName,
            final String newPassword,
            final List<Task> newTaskList
            ){
        this.name = newName;
        this.password = newPassword;
        this.taskList = newTaskList;
    }

}
