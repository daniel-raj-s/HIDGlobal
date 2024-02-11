# HIDGlobal

# Cucumber Selenium Project

## Overview
This project utilizes Cucumber for BDD-style test specifications and Selenium WebDriver for browser automation. The build process is managed by Maven, and the tests can be run locally or as part of a CI/CD pipeline with GitHub Actions.

## Project Highlights:
	Testing Framework: Cucumber (BDD) and Selenium, TestNG
	Build Tool: Maven
	CI/CD: GitHub Actions

## Requirements:
- Java 11+
- Maven 3.5+
- Chromebrowser

## Getting Started:
Clone the repository:
```bash
git clone https://github.com/daniel-raj-s/HIDGlobal.git
```
## Install dependencies:

```bash
mvn install
```

## Run the tests:
Locally:

```bash
mvn test
```

## Headless mode:

```bash
mvn test -Dcucumber.options='--tags @HID_Global'
```

Modify the `@HID_Global` tag to match your specific tag for headless tests.

## Running Tests with GitHub Actions:

This project leverages GitHub Actions to automate the CI/CD workflow. Pushing your code to the main branch triggers the workflow, which automatically:

## Runs on GitHub WorkFlows
	Run the tests
	Generate test reports
	See the .github/workflows directory for the configured workflow files.

## Folder Structure:
**features:** Cucumber feature files
**src/main/test:** Test step definitions and helper classes
**src/test/resources:** feature files and additional resources
**.github/workflows:** GitHub Actions workflow files

## Assignment Features
- **UI Assignment**: This assignment is covered in the feature file with the global tag `@UI_Assignment`.
- **API Assignment**: This assignment is covered in the feature file with the global tag `@API_Assignment`.

## Test Reports
After running the tests, ExtentReport will generate HTML reports in the `/ExtentReports` directory. These reports provide detailed information about test execution, including passed, failed, and skipped tests.

