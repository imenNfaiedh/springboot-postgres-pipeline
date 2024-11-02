pipeline {
    agent any

    tools {
        maven 'maven' // Define Maven tool to be used
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
                    sh "mvn clean install"
                }
            }
        }

        stage("Build Docker Image") {
            steps {
                // Build the Docker image using the Dockerfile
                dir("${env.WORKSPACE}") {
                    sh "docker build -t backend ."
                }
            }
        }

        stage("Run Docker Compose") {
            steps {
                // Run Docker Compose to start the application
                dir("JenkinsBackend") {
                    sh "docker compose up -d"
                }
            }
        }
    }
}
