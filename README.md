# Software Dependability Project  
## Modified Apache Commons Lang & Spring Boot Demo Application

## 📌 Project Overview

This repository contains a **Software Dependability** project focused on the analysis, validation, and deployment of a Java library using industry-standard dependability techniques.

The project is based on a **modified version of Apache Commons Lang (commons-lang3)** and a **Spring Boot demo web application** that uses selected core methods from the library.  
The goal is to demonstrate correctness, robustness, performance, and security through automated tools and CI/CD practices.

---

## 📁 Project Structure



Software-Dependability-Project/
│
├── src/ # Modified commons-lang3 library
│ ├── main/java
│ ├── test/java
│ └── pom.xml
│
├── demo-app/ # Spring Boot demo application
│ ├── src/main/java
│ ├── src/test/java
│ └── pom.xml
│
├── Dockerfile # Docker image definition
├── .github/workflows/ # CI/CD pipeline configuration
└── README.md


---

## ⚙️ Build Instructions

 Build and verify the modified library

```bash
mvn clean verify


This command:

Compiles the project

Executes all JUnit test cases

Runs code quality, license, and coverage checks

Generates artifacts only if all checks pass

🚀 Running the Demo Application
cd demo-app
mvn spring-boot:run


The application exposes REST endpoints that internally use core methods from StringUtils.

---

##🧪 Automated Testing (JUnit)

All automated test cases of the library are executed using:

mvn test


Tests are located under src/test/java

The test suite includes extensive tests for StringUtils

Running the full test suite ensures that no regressions are introduced

JUnit is the testing framework used to validate functional correctness.

---

##📊 Code Coverage (JaCoCo)

JaCoCo is integrated into the Maven lifecycle

Coverage data is collected during test execution

Reports are generated during the verify phase

This ensures that a significant portion of the codebase is exercised by tests.

---

##🧬 Mutation Testing (PiTest)

Mutation testing evaluates the effectiveness of the test suite by introducing artificial faults.

mvn org.pitest:pitest-maven:mutationCoverage


If a mutation is not detected, it indicates a weakness in the tests.

---

##⚡ Performance Testing (JMH)

JMH microbenchmarks are used to measure the performance of the most demanding components of the library.

Benchmarks target the core methods used by the demo application

Benchmarks are executed using a dedicated Maven profile

mvn clean test -Pbenchmark


This avoids benchmarking the entire library and focuses only on relevant methods.

---

##📐 Formal Specification (JML)

Core methods were formally specified using JML

Specifications were verified using OpenJML

This provides formal guarantees about method behavior beyond testing

The specifications were created and verified locally and documented in the project report.

---

##🔐 Security Analysis

Security is analyzed using multiple tools:

SonarQube Cloud – static code analysis and quality gates

Snyk – dependency vulnerability scanning

GitGuardian – secret detection

Security checks are integrated into the CI/CD pipeline, ensuring continuous security analysis.

---

##🐳 Dockerization

A Docker image is provided that bundles the modified library together with the demo application, as required.

Build the Docker image
docker build -t <dockerhub-username>/demo-app-lang3:1.0 .

Run the container
docker run -p 8080:8080 <dockerhub-username>/demo-app-lang3:1.0


The application will be accessible on port 8080.

---

##🔁 CI/CD Pipeline

The CI/CD pipeline automatically:

Builds the project

Runs all tests

Enforces quality checks

Executes security analysis

The pipeline executes:

mvn verify


ensuring that only validated and compliant code is accepted.

---

✅ Evaluation Criteria Coverage
Requirement	Status
Buildable locally and in CI/CD	✅
Automated JUnit test suite	✅
Code coverage analysis (JaCoCo)	✅
Mutation testing (PiTest)	✅
Performance benchmarks (JMH)	✅
Formal specification (JML + OpenJML)	✅
Docker image available	✅
Security analysis (Snyk, GitGuardian, Sonar)	✅
No known web vulnerabilities	✅

---

##👤 Author

Student: Abdeldhaher Ben Brahim
Course: Software Dependability
Institution: Universita degli studi di Salerno
