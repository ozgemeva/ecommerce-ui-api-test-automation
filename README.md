# End-to-End E-commerce Test Automation Framework
A comprehensive test automation framework for e-commerce applications, supporting both UI and API testing with Selenium WebDriver, REST Assured, and BDD practices.

## 🧠 Design Decisions
- UI and API tests are separated intentionally to follow the test pyramid.
- User registration business logic is validated via API for speed and stability.
- UI tests focus only on navigation and critical user interactions.

## Features

- **Full Stack Testing**: UI & API test automation in one framework
- **BDD Approach**: Cucumber with Gherkin syntax for business-readable scenarios
- **Cross-Browser Support**: Chrome, Firefox, Edge browsers
- **CI/CD Ready**: Jenkins integration for continuous testing
- **Professional Reporting**: Allure Reports with detailed test analytics
- **Design Patterns**: Page Object Model (POM) for maintainable code
- **Parallel Execution**: Faster test execution across multiple browsers

## Tech Stack

- **Programming Language**: Java 11
- **UI Automation**: Selenium WebDriver 4.x
- **API Testing**: REST Assured
- **BDD Framework**: Cucumber 7.x
- **Test Runner**: TestNG
- **Build Tool**: Maven
- **CI/CD**: Jenkins
- **Reporting**: Allure Reports
- **Version Control**: Git/GitHub

## Framework Structure
src/test/java/
├── runners/ # Test runners
├── stepDefinitions/ # BDD step implementations
├── pages/ # Page Object Model classes
├── utilities/ # Helper classes and utilities
└── resources/
├── features/ # Gherkin feature files
└── config.properties


## Test Coverage

- **UI Tests**: Login, registration, product search, cart management
- **API Tests**: REST API validation, status codes, response schemas
- **Database Validation**: SQL queries for data integrity checks
- **Cross-Browser Testing**: Multi-browser compatibility

## Getting Started ## 
- **Clone the repository**
   bash
   git clone https://github.com/ozgemeva/end-to-end-ecommerce-test-framework.git
- **Run tests with Maven**
   bash
   mvn clean test
- **Generate Allure reports** 
   bash
   mvn allure:serve

- **CI/CD Pipeline**
Framework is integrated with Jenkins for:
-Automated test execution on code changes
-Cross-browser parallel testing
-Allure report generation
-Test result notifications

**Connect with me: (https://www.linkedin.com/in/ozge-meva-yilmaz/) | ozgemeva@hotmail.com**
