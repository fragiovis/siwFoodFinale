# 🍳 SiwFood — Recipes & Chefs Web App

*Web Information Systems course (Sistemi Informativi su Web) · Università degli Studi Roma Tre (2024)*

A server-side rendered web application for publishing chefs and their recipes. Visitors browse and search, chefs manage their own recipes, and administrators manage the whole catalogue.

## Features
| Role | Can do |
|---|---|
| **Visitor** | browse chefs, recipes and ingredients; search recipes and chefs; sign up |
| **Chef** | everything a visitor can, plus create and edit their own recipes (with images and ingredient quantities) and view their profile |
| **Admin** | manage chefs (create / delete), recipes and the ingredient catalogue |

- Authentication with **Spring Security** (form login, BCrypt-hashed passwords, role-based access to `/chef/**` and `/admin/**`, role-aware redirect after login)
- Server-side validation of registrations and recipes
- Domain model: `Cuoco` (chef) 1—N `Ricetta` (recipe) N—N `Ingrediente` through `RigaRicetta` (recipe line with quantity). See `modello_siwfood.pptx` for the simplified domain model.

## Tech stack
Java 17 · Spring Boot 3.3 · Spring MVC · Spring Data JPA / Hibernate · Spring Security · Thymeleaf · PostgreSQL · Maven

## Running it
1. Create a PostgreSQL database named `siwfood`.
2. Set your database credentials in `src/main/resources/application.properties` (`spring.datasource.username` / `password`).
3. Start the app:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Open http://localhost:8081. Sample data is loaded from `src/main/resources/import.sql` at startup.
