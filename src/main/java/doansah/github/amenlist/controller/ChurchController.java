package doansah.github.amenlist.controller;

import doansah.github.amenlist.entity.Church;
import doansah.github.amenlist.entity.User;
import doansah.github.amenlist.service.ChurchService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/all")
    public ResponseEntity<Page<Church>> getAllChurches(@RequestParam(defaultValue = "10") int pageNumber,
                                                       @RequestParam(defaultValue = "10") int pageSize) {
        Page<Church> churchPage = service.getAllChurchesPaged(pageNumber, pageSize);
        return ResponseEntity.ok().body(churchPage);
    }

    @GetMapping("/{church_id}")
    public ResponseEntity<List<User>> getAllChurchMembers(@PathVariable Long church_id) {
        List<User> churchMembers = service.getChurchMembers(church_id);
        return ResponseEntity.status(HttpStatus.OK).body(churchMembers);

    }



}
