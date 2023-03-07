package ro.projects.todoapp.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.projects.todoapp.application.dto.CreateEditTaskDTO;
import ro.projects.todoapp.application.dto.CreateEditUserDTO;
import ro.projects.todoapp.domain.Task;
import ro.projects.todoapp.domain.user.User;
import ro.projects.todoapp.domain.user.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void create(final CreateEditUserDTO dto){
        final User user = new User(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getEmail(),
                dto.getPassword(),
                LocalDate.parse(dto.getJoinDate()),
                mapDtoToDomain(dto.getTaskList())
        );
        
        this.userRepository.save(user);
    }
    
    private List<Task> mapDtoToDomain(final List<CreateEditTaskDTO> dtoList){
        return dtoList.stream().map(dto -> new Task(
                dto.getUserId(),
                dto.getName(), 
                dto.getDescription(),
                LocalDate.parse(dto.getDeadLine()),
                dto.getIsDone()
        )).collect(Collectors.toList());
    }

    public void edit(final String id,final CreateEditUserDTO dto){
        final User userToEdit = this.userRepository.findById(id);

        userToEdit.update(
                dto.getName(),
                dto.getPassword(),
                mapDtoToDomain(dto.getTaskList())
        );

        this.userRepository.save(userToEdit);
    }
}
