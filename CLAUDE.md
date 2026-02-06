# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Howling Wolf API is a Kotlin/Spring Boot backend for a multiplayer werewolf (人狼) game. The UI is in a separate repository `howling-wolf-ui`.

## Build & Run Commands

```bash
# Build
./gradlew build

# Build Docker image
./gradlew jibDockerBuild

# Run locally
./gradlew bootRun

# Run tests
./gradlew test

# Single test
./gradlew test --tests "com.ort.howlingwolf.SomeTest"

# DBFlute code generation (after schema changes)
cd dbflute_howlingwolfdb && sh manage.sh 0
```

## Architecture

This project follows a layered DDD-style architecture:

```
Controller (api/controller/)
    ↓
Coordinator (application/coordinator/) - orchestrates multi-step operations
    ↓
Application Service (application/service/) - transactional boundaries
    ↓
Domain Service (domain/service/) + Domain Model (domain/model/)
    ↓
DataSource (infrastructure/datasource/) - DBFlute queries
    ↓
MySQL Database
```

### Key Directories

- `api/` - REST controllers, request bodies (`body/`), response views (`view/`)
- `application/coordinator/` - Transaction orchestration (e.g., VillageCoordinator)
- `application/service/` - Application-level services
- `domain/model/` - Rich domain entities with business logic
- `domain/service/` - Domain rules (say/, vote/, ability/, skill/, etc.)
- `infrastructure/datasource/` - DBFlute-based data access
- `infrastructure/repository/` - External integrations (Twitter, Slack, Discord)
- `fw/` - Framework concerns (security, config, exceptions)
- `com/ort/dbflute/` - Auto-generated DBFlute code (do not edit manually)

### Database

- **ORM**: DBFlute 1.3.0 (code generation + fluent query API)
- **Schema**: `dbflute_howlingwolfdb/schema/project-schema-howlingwolfdb.xml`
- Query using `XxxBhv` behavior classes with `selectEntity`, `selectList`, `queryInsert`, etc.
- Enum mappings via `CDef` classes

### Authentication

Firebase Admin SDK validates JWT tokens. See `fw/security/HowlingWolfAuthenticationProvider`.

## Domain Concepts

- **Village**: A game room with settings, participants, day/night cycle
- **VillageParticipant**: Player in a village with assigned skill (role)
- **Skill**: Player roles (Villager, Werewolf, Seer, etc.)
- **Ability**: Night actions (kill, investigate, protect)
- **Camp**: Factions (humans vs. werewolves)
- **Message**: Chat with type-based restrictions and access control

## Configuration

- Local: `src/main/resources/config/application.yml` (port 8086, context `/howling-wolf`)
- Production: `src/main/resources/config/application-production.yml` (uses env vars)

Key env vars for production:
- `MYSQL_HOST`, `HOWLING_WOLF_DB_NAME`, `HOWLING_WOLF_DB_USERNAME`, `HOWLING_WOLF_DB_PASSWORD`
- `HOWLING_WOLF_FIREBASE_ADMINSDK_PATH`, `HOWLING_WOLF_FIREBASE_DATABASE_URL`
- `SLACK_TOKEN`, `HOWLING_WOLF_DISCORD_WEBHOOK_URL`

## Code Conventions

- JSON uses snake_case (configured in HowlingWolfAppConfig)
- Domain models contain business logic; services orchestrate
- DataSource classes wrap DBFlute behavior handlers
- Views (response DTOs) are separate from domain models