# Projet CUBE - Concevoir une API et une interface utilisateur

## Table des matières
1. [Hogwarts Company - Cahier des charges](#-hogwarts-company---cahier-des-charges)
   2. [Présentation du projet](#-présentation-du-projet-)
   3. [Contexte](#-contexte)
   4. [Rôles dans l'application](#-rôles-dans-lapplication)
5. [Mise en place](#-mise-en-place-)
   6. [Choix techniques](#-choix-techniques)
   7. [Liste des tâches](#-liste-des-tâches)
   8. [API REST](#-api-rest)
   9. [Client lourd](#-client-lourd)
10. [Mise en production](#-mise-en-production)
    11. [Mode d'emploi](#-mode-demploi)
    13. [Difficultés rencontrées](#-difficultés-rencontrées)
14. [Projets pour la version 2](#-projets-pour-la-version-2)


# 💫 Hogwarts Company - Cahier des charges
## 📎 Présentation du projet 
Dans le cadre de cette évaluation, vous allez créer une application d'annuaire d'entreprise. L'application va être architecturées de cette façon :
1. Création d'une base de données
2. Manipulation des données à travers une API (Java ou C#)
3. Interface utilisateur (client lourd)

## 🏢 Contexte
Développeur informatique dans une industrie agroalimentaire sur le territoire française, l'entreprise en croissance est aujourd'hui composée avec 5 sites différents et plus de 1000 salariés : 
1. **Paris** : siège administratif
2. **Nantes** : site de production
3. **Toulouse** : site de production
4. **Nice** : site de production
5. **Lille** : site de production 

Il est nécessaire de fournir une application permettant de retrouver des informations sur chaque collaborateur : 
- Nom
- Prénom
- Fixe
- Portable
- E-mail
- Service de travail
- Site

## 🙋 Rôles dans l'application
1. **Visiteur** : rechercher et afficher des informations
   - Doit pouvoir afficher la fiche d'un autre salarié
   - Doit pouvoir faire une recherche : 
     - Par **nom, prénom** : saisie de X lettres pour afficher les salariés avec une correspondance
     - Par **site** avec une liste complète des sites 
     - Par **service** avec la liste des services
2. **Administrateur** : ajouter, modifier, supprimer des informations
   - Doit pouvoir avoir les mêmes droits que le visiteur
   - Doit pouvoir faire un CRUD : 
     - **Site** : champ ville uniquement
     - **Service** : comptabilité, production, accueil, informatique
     - **Salarié** : nom, prénom, téléphone fixe, portable, e-mail, service et site de travail

**L'accès à l'espace administrateur se fait avec une combinaison de touches et un mot de passe.**

# 💻 Mise en place 

## 🎌 Choix techniques

## ✔️ Liste des tâches

## 📝 API REST

## 💾 Client lourd

# 🏁 Mise en production

## 📂 Mode d'emploi

## ⛳ Difficultés rencontrées

# 🎡 Projets pour la version 2


