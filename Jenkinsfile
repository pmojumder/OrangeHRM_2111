pipeline {
    agent any

    environment {
        GIT_CREDENTIALS_ID = 'my_github_key'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Git checkout Started...'
                script {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: 'main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        submoduleCfg: [],
                        userRemoteConfigs: [[
                            credentialsId: env.GIT_CREDENTIALS_ID,
                            url: 'https://github.com/pmojumder/OrangeHRM_2111.git'
                        ]]
                    ])
                }
                echo 'Git checkout Completed...'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Test Execution Started...'
                bat 'mvn test'
                echo 'Test Execution Completed...'
            }
        }

        stage('Reports') {
            steps {
                echo 'Publishing test reports...'
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/surefire-reports/**', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution finished.'
        }
        success {
            echo 'Pipeline succeeded.'
        }
        failure {
            echo 'Pipeline failed.'
            emailext (
                subject: "Jenkins Job Failed: ${env.JOB_NAME}",
                body: """<p>Jenkins job <b>${env.JOB_NAME}</b> has failed.</p>
                         <p>Build URL: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
                to: 'plabani52@gmail.com,ruma.mojumder@gmail.com'
            )
        }
    }
}
