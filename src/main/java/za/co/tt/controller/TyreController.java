package za.co.tt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.Tyre;
import za.co.tt.service.ITyreService;

import java.util.List;

@RestController
@RequestMapping("/api/tyres")
public class TyreController {

    private final ITyreService tyreService;

    public TyreController(ITyreService tyreService) {
        this.tyreService = tyreService;
    }

    @GetMapping
    public ResponseEntity<List<Tyre>> getAllTyres() {
        return ResponseEntity.ok(tyreService.getAllTyres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tyre> getTyreById(@PathVariable Long id) {
        return ResponseEntity.ok(tyreService.getTyreById(id));
    }

    @PostMapping
    public ResponseEntity<Tyre> createTyre(@RequestBody Tyre tyre) {
        return ResponseEntity.ok(tyreService.createTyre(tyre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tyre> updateTyre(@PathVariable Long id, @RequestBody Tyre tyre) {
        return ResponseEntity.ok(tyreService.updateTyre(id, tyre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTyre(@PathVariable Long id) {
        tyreService.deleteTyre(id);
        return ResponseEntity.noContent().build();
    }
}