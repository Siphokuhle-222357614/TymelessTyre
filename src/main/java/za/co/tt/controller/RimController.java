package za.co.tt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import za.co.tt.domain.Rim;
import za.co.tt.service.IRimService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/rims")
public class RimController {

    private final IRimService rimService;

    public RimController(IRimService rimService) {
        this.rimService = rimService;
    }

    @GetMapping
    public ResponseEntity<List<Rim>> getAllRims() {
        return ResponseEntity.ok(rimService.getAllRims());
    }

    @GetMapping("api/{id}")
    public ResponseEntity<Rim> getRimById(@PathVariable Long id) {
        return ResponseEntity.ok(rimService.getRimById(id));
    }

    @PostMapping
    public ResponseEntity<Rim> createRim(@RequestBody Rim rim) {
        return ResponseEntity.ok(rimService.createRim(rim));
    }

    @PutMapping("api/{id}")
    public ResponseEntity<Rim> updateRim(@PathVariable Long id, @RequestBody Rim rim) {
        return ResponseEntity.ok(rimService.updateRim(id, rim));
    }

    @DeleteMapping("api/{id}")
    public ResponseEntity<Void> deleteRim(@PathVariable Long id) {
        rimService.deleteRim(id);
        return ResponseEntity.noContent().build();
    }
}