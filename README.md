# ZenCare
# 🏥 ZenCare - Application de Suivi Médical

**ZenCare** est une application de bureau développée en **Java Swing** avec une base de données **MySQL**. Elle est conçue pour aider les patients à suivre leur traitement thérapeutique au quotidien, paramétrer la durée de leurs médicaments et générer des bilans de santé sécurisés.

---

## Fonctionnalités Principales

- **Authentification & Inscription** : Accès sécurisé pour chaque utilisateur.
- **Paramétrage du Traitement (Page 2)** :
  - Choix du médicament et de la durée du traitement (en jours).
  - Sélection des moments de prise (*Matin*, *Déjeuner*, *Dîner*).
- **Suivi Journalier Intelligente (Page 3)** :
  - Enregistrement automatique de la **date système** au format `JJ/MM/AAAA`.
  - **Verrouillage dynamique des cases (`JCheckBox.setEnabled(false)`)** : Seuls les moments de prise définis lors du paramétrage restent actifs.
  - Saisie d'observations et de descriptions par le patient.
- **Bilan Final Sécurisé (Page 4)** :
  - Extraction dynamique de la dernière session (`ORDER BY id DESC LIMIT 1`).
  - Affichage non modifiable des prises et des remarques sous forme de rapport médical.

---

## Technologies & Outils

* **Langage de programmation** : Java (JDK 8+)
* **Interface Graphique (GUI)** : Java Swing / AWT
* **Base de données** : MySQL
* **Connecteur BD** : JDBC (`mysql-connector-j`)
* **Environnement de développement (IDE)** : Eclipse / VS Code

---

## Structure de la Base de Données

La table principale `medicament` est structurée comme suit :

| Colonne | Type | Description |
| :--- | :--- | :--- |
| `id` | `INT (AUTO_INCREMENT)` | Clé primaire unique |
| `Trait` | `VARCHAR` | Nom du traitement / patient |
| `Dure` | `INT` | Durée du traitement en jours |
| `Nommed` | `VARCHAR` | Nom du médicament |
| `Jour` | `VARCHAR` | Date système (`dd/MM/yyyy`) |
| `Dose` | `VARCHAR` | Dose prescrite |
| `Temps` | `VARCHAR` | Moments retenus (*Matin Dejeuner Diner*) |
| `des` | `TEXT` | Observations du patient |

---

##  Installation & Configuration

1. **Cloner le dépôt Git** :
   ```bash
   git clone [https://github.com/votre-compte/ZenCare.git](https://github.com/votre-compte/ZenCare.git)
