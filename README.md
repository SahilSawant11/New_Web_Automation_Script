# Web Automation Tests Scripts 

Welcome to the **Web Automation Test Scripts ** repository! This project contains a comprehensive suite of automation scripts for web testing, built using **Java**, **Selenium WebDriver**, **TestNG**, and **ExtentReports**. The automation scripts are designed to help efficiently test and validate web applications by simulating user interactions with the application.

## Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Setup](#setup)
  - [Running the Tests](#running-the-tests)
- [Test Reports](#test-reports)
- [Directory Structure](#directory-structure)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

The **Web Automation Project** automates end-to-end testing for web applications, allowing for the rapid and reliable execution of test cases across various browsers and environments. Using Selenium WebDriver, we simulate user actions (such as clicks, typing, navigation, etc.) to test the functionality of web elements. TestNG is employed to manage and organize test cases, and ExtentReports is utilized for generating detailed, visually appealing reports.

This repository provides a scalable and flexible framework that can be easily extended to suit specific web automation needs.

---

## Tech Stack

- **Java**: The core programming language used to write the test scripts.
- **Selenium WebDriver**: A powerful tool for automating browsers, used to interact with web elements and simulate user actions.
- **TestNG**: A testing framework used to organize and run the test cases, supporting parallel execution, grouping, and reporting.
- **ExtentReports**: A reporting tool that generates detailed, interactive, and visually rich reports to provide insights into test execution results.
- **Eclipse IDE**: Integrated development environment for writing, editing, and debugging the test scripts.

---

## Getting Started

To get started with the Web Automation Project, follow the steps below:

### Prerequisites

Before setting up the project, ensure you have the following installed on your local machine:

- **Java JDK** (version 8 or above)
- **Eclipse IDE** (or any Java-supported IDE)
- **Maven** (for managing dependencies)
- **Selenium WebDriver** (managed via Maven)
- **TestNG** (also managed via Maven)
- **ChromeDriver** (or another driver for the browser of your choice)

You can install the necessary dependencies using the Maven `pom.xml` file provided in the project.

### Setup

1. **Clone the Repository**:
   Start by cloning the repository to your local machine:
   ```bash
   git clone https://github.com/your-username/web-automation-project.git
   ```

2. **Open in Eclipse**:
   Open the project in Eclipse IDE by selecting `File` > `Import` > `Existing Maven Projects`.

3. **Install Dependencies**:
   Maven will automatically fetch all required dependencies (like Selenium, TestNG, ExtentReports) based on the `pom.xml` file. Ensure that you have an internet connection when doing this.

4. **Configure WebDriver**:
   Download the necessary WebDriver executable (e.g., ChromeDriver, GeckoDriver) and place it in your `drivers/` folder. Make sure the path to the WebDriver is set correctly in your code or system environment.

---

### Running the Tests

Once you’ve set up the project, you can run the automation scripts via **TestNG**.

1. **Run Tests in Eclipse**:
   Right-click on the `TestNG` test suite file (usually located in `src/test/java`), then select **Run As** > **TestNG Test**.

2. **Run Tests from Command Line**:
   Navigate to the project root folder in your terminal and run:
   ```bash
   mvn test
   ```

This will run all the test cases and generate an **ExtentReport** for the executed tests.

---

## Test Reports

After running the tests, ExtentReports will generate a detailed HTML report that provides insights into the status and execution of each test case. The report includes:

- Pass/Fail status of each test case
- Screenshots of failed tests (if configured)
- Execution time for each test case
- Logs and messages detailing the steps of each test

The report will be saved in the `test-output/` directory under `extentReports/`.

---

## Directory Structure

Here’s the structure of the project:

```
web-automation-project/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── yourcompany/
│   │               └── pages/                # Page Object Model classes
│   │               └── utils/                # Utility classes (e.g., WebDriver manager, configurations)
│   └── test/
│       └── java/
│           └── com/
│               └── yourcompany/
│                   └── tests/                # Test scripts (TestNG test cases)
│                   └── listeners/            # ExtentReports listeners
│
├── drivers/                                    # WebDriver executables (ChromeDriver, GeckoDriver, etc.)
├── test-output/                                # Test execution reports (ExtentReports)
├── pom.xml                                     # Maven dependencies and project configuration
└── README.md                                   # Project documentation
```

---

## Features

- **Cross-browser Testing**: Run tests on different browsers like Chrome, Firefox, and Safari.
- **Parallel Execution**: TestNG allows for the parallel execution of tests to reduce overall runtime.
- **Screenshot Capture**: Automatically take screenshots for failed tests for better debugging.
- **Extensive Reports**: ExtentReports generates detailed HTML reports with logs and screenshots.
- **Page Object Model**: Uses the Page Object Model design pattern for better code maintainability.

---

## Contributing

We welcome contributions to improve this Web Automation Project! If you have any suggestions or enhancements, feel free to fork the repository, create a new branch, and submit a pull request.

### Steps to Contribute:
1. Fork the repository.
2. Create a feature branch.
3. Make your changes or improvements.
4. Push to your forked repository.
5. Create a pull request to the `main` branch of the original repository.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Thank you for checking out the **Web Automation Project**! We hope it helps you streamline your web application testing and ensures high-quality user experiences.
