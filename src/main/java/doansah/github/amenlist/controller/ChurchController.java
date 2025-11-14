package doansah.github.amenlist.controller;

import doansah.github.amenlist.entity.User;
import doansah.github.amenlist.service.ChurchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/church")
public class ChurchController {
    private ChurchService service;

    public ChurchController(ChurchService service) {
        this.service = service;
    }

    @GetMapping("/{church_id}")
    public ResponseEntity<List<User>> getAllChurchMembers(@PathVariable Long church_id) {
        List<User> churchMembers = service.getChurchMembers(church_id);
        return ResponseEntity.of().build();

    }



}
