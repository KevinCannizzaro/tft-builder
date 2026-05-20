package com.kevincompany.tft_team_builder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.List;

@Entity
@Table(name = "champions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int cost;

    @Column
    private String imageUrl;

    @ElementCollection
    @CollectionTable(name = "champion_traits", joinColumns = @JoinColumn(name = "champion_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "trait_name")
    private List<String> traits;
}