pipeline {
    agent any

	environment {
        PATH = "/usr/local/bin"
    }
    stages {
        stage('Pull latest Code') { 
		
             steps {
              // Get some code from a GitHub repository
              git 'https://github.com/arasu078/pipelinepoctest.git'
             }
        }
		stage('spinning up docker images'){
        	steps {
			 withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
     
                	sh 'docker-compose up -d' 
             }	
        }
		}
        stage('Build') { 
            steps {
		withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
                sh '/Users/mponnar/Documents/apache-maven-3.8.2/bin/mvn -B -DskipTests clean package' 
            }
	  }
        }
        stage('Test') {
            steps {
		withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
                sh '/Users/mponnar/Documents/apache-maven-3.8.2/bin/mvn test'
            }
	  }
        }
        stage('Destroy - After Running tests on Containers') { 
            steps {
		withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
                sh 'docker stop $(docker ps -a -q)'
                sh 'docker rm $(docker ps -a -q)'
		}
            }
        }
    }
post {
	always {
	      step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
		publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: '', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
	}
}

}
