package ro.projects.todoapp.interfaces;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.projects.todoapp.application.UserService;
import ro.projects.todoapp.application.dto.CreateEditUserDTO;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@CrossOrigin
public class UserRestController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(final @RequestBody CreateEditUserDTO dto){
        this.userService.create(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> edit(final @PathVariable String id,final @RequestBody CreateEditUserDTO dto){
        this.userService.edit(id,dto);
        return ResponseEntity.ok().build();
    }
}
