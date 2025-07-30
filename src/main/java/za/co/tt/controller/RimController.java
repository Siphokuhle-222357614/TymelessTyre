package za.co.tt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.Rim;
import za.co.tt.service.RimService;

import java.util.List;

@RestController
@RequestMapping("/api/rims")
public class RimController {

    private final RimService rimService;

    public RimController(RimService rimService) {
        this.rimService = rimService;
    }

    @GetMapping
    public ResponseEntity<List<Rim>> getAllRims() {
        return ResponseEntity.ok(rimService.getAllRims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rim> getRimById(@PathVariable Long id) {
        return ResponseEntity.ok(rimService.getRimById(id));
    }

    @PostMapping
    public ResponseEntity<Rim> createRim(@RequestBody Rim rim) {
        return ResponseEntity.ok(rimService.createRim(rim));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rim> updateRim(@PathVariable Long id, @RequestBody Rim rim) {
        return ResponseEntity.ok(rimService.updateRim(id, rim));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRim(@PathVariable Long id) {
        rimService.deleteRim(id);
        return ResponseEntity.noContent().build();
    }
}