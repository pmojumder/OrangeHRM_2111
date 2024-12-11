pipeline {
    agent any  // Run on any available Jenkins agent

    tools {
        maven 'Maven 3.6.3'  // Specify Maven version (make sure Maven is installed and configured in Jenkins)
        jdk 'JDK 11'         // Specify JDK version (make sure JDK is configured in Jenkins)
    }

    environment {
        MVN_HOME = tool name: 'Maven 3.6.3', type: 'Tool'  // Set Maven home path
    }

    stages {
        // Stage 1: Checkout Code from GitHub (or any other repository)
        stage('Checkout') {
            steps {
                checkout scm  // Checkout code from the repository
            }
        }

        // Stage 2: Build the Project
        stage('Build') {
            steps {
                script {
                    // Clean and build the project with Maven, skipping the tests to save time
                    sh "${MVN_HOME}/bin/mvn clean install -DskipTests"
                }
            }
        }

        // Stage 3: Run TestNG Tests
        stage('Run TestNG Tests') {
            steps {
                script {
                    // Run the tests using Maven (runs TestNG tests as per the pom.xml configuration)
                    sh "${MVN_HOME}/bin/mvn test"
                }
            }
        }

        // Stage 4: Archive TestNG Emailable Report
        stage('Archive TestNG Emailable Report') {
            steps {
                // Archive the TestNG Emailable HTML report (usually found in target/surefire-reports)
                archiveArtifacts allowEmptyArchive: true, artifacts: 'target/surefire-reports/emailable-report.html', onlyIfSuccessful: true
            }
        }

        // Stage 5: Publish TestNG Emailable Report
        stage('Publish TestNG Report') {
            steps {
                // Publish the TestNG HTML report (if using the Maven Surefire Plugin, the reports are in target/surefire-reports)
                publishHTML(target: [
                    reportName: 'TestNG Emailable Report',          // Name of the report
                    reportDir: 'target/surefire-reports',           // Directory where Surefire stores reports
                    reportFiles: 'emailable-report.html',          // The Emailable HTML report file
                    keepAll: true
                ])
            }
        }
    }

    post {
        always {
            // Clean workspace after the build to free up space
            cleanWs()
        }

        success {
            echo 'Build and TestNG tests completed successfully!'
        }

        failure {
            echo 'Build or tests failed!'
        }
    }
}
 
