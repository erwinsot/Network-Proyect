pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                // Aquí irían los pasos de construcción de tu proyecto
                echo 'Construyendo...'
                // Ejemplo de un paso de construcción real:
                // sh 'npm install'
            }
        }
        stage('Test') {
            steps {
                // Aquí irían los pasos de prueba de tu proyecto
                echo 'Probando...'
                // Ejemplo de un paso de prueba real:
                // sh 'npm test'
            }
        }
        stage('Deploy') {
            steps {
                // Aquí irían los pasos de despliegue de tu proyecto
                echo 'Desplegando...'
                // Ejemplo de un paso de despliegue real:
                // sh 'npm deploy'
            }
        }
    }
}
