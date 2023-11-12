pipeline {
    agent {
        docker { image 'debian:xvfb' }
    }
    stages {
        stage('checkout') {
            steps {
                checkout scm
            }
        }
         stage('RunTest') {
            steps {
                wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: true, displayNameOffset: 0, installationName: 'Xvfb', parallelBuild: true, screen: '1024x758x24', timeout: 25]) {
                sh 'mvn -B clean test'
                }
            }
        }
         stage('Test') {
            steps {
                wrap([$class: 'Xvfb', additionalOptions: '', assignedLabels: '', autoDisplayName: true, debug: true, displayNameOffset: 0, installationName: 'Xvfb', parallelBuild: true, screen: '1024x758x24', timeout: 25]) {
                sh 'mvn -version'
                }
            }
        }
    }
}