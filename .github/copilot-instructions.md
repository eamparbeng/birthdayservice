# Copilot / AI Agent Instructions for BirthdayService

Purpose: Help AI coding agents become productive quickly in this Spring Boot Gradle project.

- **Project type:** Java Spring Boot (single-module Gradle) using Java 17 toolchain and Spring Boot 4.
- **Entry point:** `src/main/java/io/acsint/birthdayservice/BirthdayServiceApplication.java` (SpringApplication main).
- **Build & run:** Use the Gradle wrapper in repo root.

Examples:
```
./gradlew build       # compile + tests
./gradlew bootRun     # run the app locally
./gradlew test        # run tests
```

Key files & locations to inspect first
- `build.gradle` — dependency list and Spring Boot plugin configuration (Java 17 toolchain).
- `src/main/java/io/acsint/birthdayservice/` — main package; controllers/services will live here.
- `src/main/resources/application.properties` — runtime configuration such as `spring.application.name`.
- `src/main/resources/static/` and `src/main/resources/templates/` — static assets and server-side templates.
- `test/java/io/acsint/birthdayservice/` — unit/integration tests mirror package structure.

Architecture & intent (what I observed)
- Small monolithic Spring Boot service: main class boots the app; web MVC starter is used.
- No separate modules or external microservice wiring in-tree; expect HTTP controllers + service layer inside the single package.
- Gradle wrapper is authoritative—use `./gradlew` for reproducible builds.

Coding conventions and patterns to follow
- Package layout mirrors `io.acsint.birthdayservice`. Keep new types under this root package.
- Tests follow JUnit Platform (configured in `build.gradle`). Use `@SpringBootTest` only when needed; prefer slice tests for controllers.
- Configuration: prefer `application.properties` for defaults; environment and CI override with standard Spring Boot mechanisms.

Common tasks & examples
- Add a REST controller:
  - Place under `src/main/java/io/acsint/birthdayservice/controller`.
  - Keep request/response DTOs in a `dto` subpackage.
- Add a unit test:
  - Place under `test/java/io/acsint/birthdayservice/...` mirroring the class package.
  - Run `./gradlew test` to validate.

Integration points & dependencies
- Uses `spring-boot-starter-webmvc` — HTTP endpoints expected.
- No external datastore dependency found in `build.gradle` (if you add one, update `build.gradle` and provide config in `application.properties`).

What to avoid
- Do not assume multi-module or Maven; edits should preserve Gradle build and wrapper use.
- Avoid changing the Java toolchain unless explicitly required—project targets Java 17.

If you update or create files
- Run `./gradlew build` locally to ensure compilation and tests pass.
- Keep package names consistent with `io.acsint.birthdayservice`.

When unsure or making larger changes
- Ask (or open a PR) describing intent, files changed, and local verification steps (build + test results).

If you find existing `.github/copilot-instructions.md` or similar files, merge their actionable contents into this file rather than duplicating.

---
Please review these notes and tell me if you want stricter formatting rules, more examples, or added CI/PR guidance.
