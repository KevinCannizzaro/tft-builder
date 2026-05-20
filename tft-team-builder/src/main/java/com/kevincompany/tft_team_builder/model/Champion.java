package com.kevincompany.tft_team_builder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.URL;
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
    @NotBlank(message = "Le nom du champion est obligatoire")
    private String name;

    @Column(nullable = false)
    @Min(value = 1, message = "Le coût minimum est de 1")
    @Max(value = 5, message = "Le coût maximum est de 5")
    private int cost;

    @Column
    @URL(message = "L'URL de l'image doit être valide")
    private String imageUrl;

    @ElementCollection
    @CollectionTable(name = "champion_traits", joinColumns = @JoinColumn(name = "champion_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "trait_name")
    private List<String> traits;
}