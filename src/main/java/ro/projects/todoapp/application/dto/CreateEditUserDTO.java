package ro.projects.todoapp.application.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateEditUserDTO {
    private String name;
    private String email;
    private String password;
    private String joinDate;
    private List<CreateEditTaskDTO> taskList;
}
