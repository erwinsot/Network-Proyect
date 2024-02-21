pipeline {
    agent any
    
    stages {
        stage('verify tooling') {
            steps {
                steps {
                    sh 'java -version'
                    sh 'mvn -version'
                    sh 'git --version'
                    sh 'docker -- info'
                    sh 'docker-compose --version'
                    sh 'docker version'
                    
                }
            }
        }
        
        stage('Test') {
            steps {
                // Add your test steps here
            }
        }
        
        stage('Deploy') {
            steps {
                // Add your deployment steps here
            }
        }
    }
}
