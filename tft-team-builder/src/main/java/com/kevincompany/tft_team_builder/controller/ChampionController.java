package com.kevincompany.tft_team_builder.controller;

import com.kevincompany.tft_team_builder.model.Champion;
import com.kevincompany.tft_team_builder.service.ChampionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/champions")
@RequiredArgsConstructor
public class ChampionController {

    private final ChampionService championService;

    @GetMapping
    public List<Champion> getAllChampions() {
        return championService.getAllChampions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Champion> getChampionById(@PathVariable Long id) {
        return championService.getChampionById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Champion> addChampion(@RequestBody Champion champion) {
        return new ResponseEntity<>(championService.addChampion(champion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Champion> updateChampion(@PathVariable Long id, @RequestBody Champion champion) {
        return ResponseEntity.ok(championService.updateChampion(id, champion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChampion(@PathVariable Long id) {
        championService.deleteChampion(id);
        return ResponseEntity.noContent().build();
    }
}