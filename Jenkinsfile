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
       
    }
}
