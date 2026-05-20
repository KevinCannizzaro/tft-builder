package com.kevincompany.tft_team_builder.repository;

import com.kevincompany.tft_team_builder.model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {
    // Tu pourras ajouter des méthodes personnalisées ici plus tard,
    // par exemple : List<Champion> findByCost(int cost);
}