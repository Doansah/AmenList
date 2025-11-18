package doansah.github.amenlist.controller;


import doansah.github.amenlist.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import doansah.github.amenlist.service.UserService;

import java.awt.print.Pageable;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<?> getUsers(@RequestParam(defaultValue = "10") int pageNumber,
                                      @RequestParam(defaultValue = "10") int pageSize) {
        Page<User> page = service.findAll(pageNumber, pageSize);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
