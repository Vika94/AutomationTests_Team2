pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
        jdk 'Java 11'
    }

    stages {
        stage('Test run') {
            steps {
                // Run Maven on a Unix agent.
                bat 'mvn clean test -Dsuite=src/test/resources/allTests.xml'
            }
        }

        /* stage('Reports') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])}
               }
        } */
    }
}
