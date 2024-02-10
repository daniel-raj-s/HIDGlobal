# HIDGlobal

# Cucumber Selenium Project

## Overview
This project is a Java-based automation framework utilizing Cucumber, Selenium, TestNG, ExtentReport, and Rest Assured. It's designed to facilitate automated testing of web applications with features such as BDD (Behavior Driven Development) style test scenarios, reporting capabilities, and integration with Maven for dependency management and build automation.

## Prerequisites
- Java JDK installed
- Maven installed
- Chrome browser installed

## Setup
1. Clone this repository to your local machine.
2. Ensure all necessary dependencies are installed and configured.

## Project Structure
- **src/test/java**: Contains test code.
- **src/test/resources**: Contains resources such as feature files and configuration files.
- **ExtentReports**: html,spark,pdf reports will be generated under this folder
- **pom.xml**: Maven configuration file specifying project dependencies and build settings.

## Running the Project
### Via TestRunner
1. Navigate to the project root directory in your terminal.
2. Execute the following command:

```bash
mvn clean test
```

This command will trigger the TestNG test execution using the configured TestRunner.

### Via Maven Commands
1. Navigate to the project root directory in your terminal.
2. Execute the following command to compile and package the project:

```bash
mvn clean install
```

3. Execute the following command to run the tests:

```bash
mvn test
```

This command will compile the project, run the tests, and generate test reports using the configured plugins.

## Test Reports
After running the tests, ExtentReport will generate HTML reports in the `/ExtentReports` directory. These reports provide detailed information about test execution, including passed, failed, and skipped tests.

