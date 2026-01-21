# BirthdayService

Small Spring Boot service that exposes HTTP endpoints. Built with Java 17 and Spring Boot 4.

Build & run

```bash
./gradlew build       # compile + tests
./gradlew bootRun     # run the app locally
```

Example endpoints

- GET /help — returns a JSON greeting. Query parameter: `name` (optional).

Examples

```bash
# No name provided
curl -sS http://localhost:8080/help | jq
# => { "message": "Hello world", "name": "world" }

# With name
curl -sS 'http://localhost:8080/help?name=Alice' | jq
# => { "message": "Hello Alice", "name": "Alice" }

# Blank name (treated as missing)
curl -sS 'http://localhost:8080/help?name=   ' | jq
# => { "message": "Hello world", "name": "world" }
```

Notes for developers

- Entry point: `src/main/java/io/acsint/birthdayservice/BirthdayServiceApplication.java`.
- Controller example: `src/main/java/io/acsint/birthdayservice/controller/HelpController.java`.
- Tests live under `test/java/io/acsint/birthdayservice/` and use JUnit + Spring test slices.
