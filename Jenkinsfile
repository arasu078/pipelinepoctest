// Build once a day with a parameter
CRON_SETTINGS = '''H H * * * % ENV=DEV''' : ""

pipeline {
    agent any
    
    triggers {
    parameterizedCron('''H H * * * % ENV=master''' : "")
  }
    environment {
        PATH = "/usr/local/bin"
    }
    
    stages {
        // GIT CHECKOUT
        stage('Pull latest Code') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/arasu078/pipelinepoctest.git'
            }
        }
        // DOCKER SPINNING
        stage('spinning up docker images'){
            steps {
                withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
                    
                    sh 'docker-compose up -d'
                }
            }
        }
        // BUILDING
        stage('Build') {
            steps {
                withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
                    sh '/Users/mponnar/Documents/apache-maven-3.8.2/bin/mvn -B -DskipTests clean package'
                }
            }
        }
        // TEST
        stage('Test') {
            steps {
                withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
                    sh '/Users/mponnar/Documents/apache-maven-3.8.2/bin/mvn test'
                }
            }
        }
        // DESTROY DOCKER
        stage('Destroy - After Running tests on Containers') {
            steps {
                withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
                    sh 'docker stop $(docker ps -a -q)'
                    sh 'docker rm $(docker ps -a -q)'
                }
            }
        }
    }
    // POST BUILD ACTIONS
    post {
        always {
            // REPORT GENERATION
            step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
            
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: '', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
        }
    }
    
}
