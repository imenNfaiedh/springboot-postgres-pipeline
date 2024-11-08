pipeline {
    agent any

    tools {
        maven 'install maven' // Define Maven tool to be used
    }

    stages {
        stage("Clean up") {
            steps {
                deleteDir() // Clean up the workspace before starting
            }
        }

        stage("Checkout SCM") {
            steps {

                checkout scm

            }
        }

        stage("Build project") {
            steps {
                // Navigate to the project directory and build the Maven project
                dir("${env.WORKSPACE}") {
                    bat "mvn clean install"
                }
            }
        }

        stage("Build Docker Image") {
            steps {
                // Build the Docker image using the Dockerfile
                dir("${env.WORKSPACE}") {
                    bat "docker build -t backend ."
                }
            }
        }

        stage("Run Docker Compose") {
            steps {
                // Run Docker Compose to start the application
                dir("springboot-postgres-pipeline") {
                    bat "docker compose up -d"
                }
            }
        }
    }
}
