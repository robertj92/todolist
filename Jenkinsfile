pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './mvnw clean install -DskipTests'
            }
        }

        stage('Code Analysis') {
            steps {
                sh './mvnw checkstyle:checkstyle'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
    }
}