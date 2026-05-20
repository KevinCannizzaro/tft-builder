# TFT Team Builder - Backend API

## 📝 Description
Ce projet est une API REST développée avec **Spring Boot** permettant de gérer une base de données de champions pour le jeu Teamfight Tactics (TFT). L'objectif final est de créer un outil d'aide à la composition d'équipes (Team Builder) en gérant les synergies, les coûts et les statistiques des champions.

## 🚀 Technologies Utilisées
*   **Java 21** : Langage de programmation principal.
*   **Spring Boot 3+** : Framework pour le développement rapide d'applications Java.
    *   **Spring Web** : Pour la création de l'API REST.
    *   **Spring Data JPA** : Pour la persistance des données et la communication avec la base SQL.
*   **Lombok** : Bibliothèque pour réduire le code "boilerplate" (génération automatique des Getters, Setters, Constructeurs).
*   **Hibernate** : Implémentation de JPA pour le mapping objet-relationnel (ORM).
*   **Maven** : Gestionnaire de dépendances et de build.
*   **SQL (MySQL/PostgreSQL)** : Base de données relationnelle pour stocker les champions.

## 🧠 Notions d'Architecture Appliquées
Le projet suit une architecture en couches (N-Tier) pour assurer la séparation des responsabilités :
1.  **Modèle (Model/Entity)** : Représentation des données en base (Classe `Champion`).
2.  **Dépôt (Repository)** : Interface gérant les requêtes SQL via Spring Data JPA.
3.  **Service** : Couche "Métier" contenant la logique de l'application (validation, calculs).
4.  **Contrôleur (Controller)** : Point d'entrée de l'API recevant les requêtes HTTP.

### Concepts clés :
*   **Injection de dépendances** : Utilisation de `@RequiredArgsConstructor` pour injecter automatiquement les composants.
*   **Mapping Relationnel** : Gestion des collections d'éléments (Traits) avec `@ElementCollection` et `@CollectionTable`.
*   **Cascade Delete** : Utilisation de `@OnDelete` pour garantir l'intégrité référentielle lors de la suppression d'un champion.

## 🛠️ Installation et Lancement
1.  Cloner le dépôt.
2.  Configurer la connexion à votre base de données locale dans `src/main/resources/application.properties`.
3.  Lancer l'application avec Maven :
    ```bash
    ./mvnw spring-boot:run
    ```

## 📡 Points d'accès API (Endpoints)
L'API est accessible par défaut sur `http://localhost:8080/api/champions`.

| Méthode | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/champions` | Récupérer tous les champions |
| **GET** | `/api/champions/{id}` | Récupérer un champion par son ID |
| **POST** | `/api/champions` | Ajouter un nouveau champion |
| **PUT** | `/api/champions/{id}` | Modifier un champion existant |
| **DELETE** | `/api/champions/{id}` | Supprimer un champion |

## 🧪 Exemple de JSON pour POST
```json
{
    "name": "Ahri",
    "cost": 2,
    "imageUrl": "https://url-de-l-image.png",
    "traits": ["Arcana", "Scholar"]
}
```

## 📈 Évolutions à venir
- [ ] Ajout d'une entité `Trait` (Synergie) avec des paliers de bonus.
- [ ] Mise en place de validations (Bean Validation) sur les entrées.
- [ ] Intégration avec l'API Community Dragon pour synchroniser les données réelles du jeu.
- [ ] Création d'un front-end (React/Angular) pour visualiser les équipes.

---
*Développé par Kévin Cannizzaro*