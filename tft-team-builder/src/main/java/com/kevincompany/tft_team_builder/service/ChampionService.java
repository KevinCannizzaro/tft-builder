package com.kevincompany.tft_team_builder.service;

import com.kevincompany.tft_team_builder.model.Champion;
import com.kevincompany.tft_team_builder.repository.ChampionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChampionService {

    private final ChampionRepository championRepository;

    public List<Champion> getAllChampions() {
        return championRepository.findAll();
    }

    public Optional<Champion> getChampionById(Long id) {
        return championRepository.findById(id);
    }

    public Champion addChampion(Champion champion) {
        return championRepository.save(champion);
    }

    public Champion updateChampion(Long id, Champion championDetails) {
        return championRepository.findById(id).map(champion -> {
            champion.setName(championDetails.getName());
            champion.setCost(championDetails.getCost());
            champion.setImageUrl(championDetails.getImageUrl());
            champion.setTraits(championDetails.getTraits());
            return championRepository.save(champion);
        }).orElseThrow(() -> new RuntimeException("Champion non trouvé avec l'id : " + id));
    }

    public void deleteChampion(Long id) {
        championRepository.deleteById(id);
    }
}