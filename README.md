# AssignmentAPI

This repository contains automated API tests written in Java using Maven, RestAssured and Allure for reporting.

Quick overview
- Language: Java
- Build: Maven
- Test framework: JUnit/TestNG (followed project conventions)
- HTTP client: RestAssured
- Reports: Allure (results are stored in `allure-results/`)

Prerequisites
- Java 11+ (or the JDK version used by the project)
- Maven 3.6+
- Optional: Allure CLI for generating HTML reports (https://docs.qameta.io/allure/)

How to run tests (Windows - cmd.exe)

1. Run the full test suite:

```cmd
cd C:\Automation\AssignmentAPI
mvn test
```

2. Run a single test class (replace the class path/name):

```cmd
mvn -Dtest=package.path.ClassName#methodName test
```
Example to run all tests in a class:
```cmd
mvn -Dtest=**/ResReqRequestBuilderTest test
```

3. Generate an Allure report (optional)
- If you have Allure installed, generate and serve the report with:

```cmd
mvn test
allure serve allure-results
```

If `allure` is not on your PATH, you can install it or use other CI to publish reports.

Notes about configuration
- API base URLs, keys, and sensitive values should be set via environment variables or a secure configuration file. Do not commit secrets to the repository.
- Common configuration is located under `src/test/resources` or in utility classes (search for `BasePaths`, `Authorisations`, etc.).

Working with GitHub and code reviews
1. Create a feature branch locally:

```cmd
git checkout -b feature/your-change
```

2. Commit and push:

```cmd
git add .
git commit -m "Describe your change"
git push -u origin feature/your-change
```

3. Open a Pull Request on GitHub: add reviewers, link issues, and include a short description of what to test.

Recommended repository files to add if you plan on external reviews:
- `README.md` (this file)
- `CONTRIBUTING.md` (guidelines for contributors)
- `.github/PULL_REQUEST_TEMPLATE.md` (PR checklist)
- `CODEOWNERS` (auto-request reviewers)
- A CI workflow (GitHub Actions) to run `mvn test` on PRs and publish Allure reports.

Troubleshooting
- If Maven fails due to JDK mismatch, ensure `JAVA_HOME` points to the correct JDK.
- If tests fail due to network/API availability, verify the target API endpoints and any required test data or API keys.

Contact / Next steps
If you'd like, I can:
- Add a minimal `CONTRIBUTING.md` and PR template.
- Add a GitHub Actions workflow to run tests and publish results.
- Add examples for running a single test class or method with concrete class names from the repo.

---
Generated README for the AssignmentAPI project.

