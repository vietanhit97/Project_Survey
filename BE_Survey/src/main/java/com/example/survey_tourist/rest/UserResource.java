package com.example.survey_tourist.rest;


import com.example.survey_tourist.dto.UserDto;
import com.example.survey_tourist.entity.User;
import com.example.survey_tourist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable final String  id){
        return ResponseEntity.ok(userService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createUser(@RequestBody @Valid final UserDto userDto) {
        return new ResponseEntity<>(userService.create(userDto),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable final  Integer id,@RequestBody @Valid UserDto userDto ){
        userService.update(id,userDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable final Integer id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/user-info")
    @CrossOrigin(value = "*",methods = RequestMethod.GET)
    public ResponseEntity<UserDto> getUserLogin(@RequestParam(required = false, defaultValue = "") String userName) {
        User user = userService.getUser(userName);
        System.out.println(user.getUserName());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setRoleId(user.getRole().getId());
        userDto.setUserName(user.getUserName());
        userDto.setRoleName(user.getRole().getNameRole());
        return ResponseEntity.ok(userDto);
    }
}
