pipeline {
    agent any
 
	environment { 
        DOCKERHUB_PASS = credentials('password_docker')
    }
    stages{
    	stage("Building the student survey image"){
    		steps{
    			script{
		    		checkout scm
		    		sh 'ls'
		    		sh 'cd Assignment1/src/main/webapp && jar -cvf Assignment1.war *'
		    		sh("sudo -S docker build --tag hshen2/studentsurvey645:${BUILD_TIMESTAMP} .")
		    		sh("echo ${BUILD_TIMESTAMP}")
		    		sh('sudo docker login -u hshen2 -p \"${DOCKERHUB_PASS}\"')
		    	}
    		}
    	
    	
    	}
    
        stage ("pushing image to dockerhub") {
            steps {
            	script{
                	sh("sudo docker push hshen2/studentsurvey645:${BUILD_TIMESTAMP}")
                }
            }
        }
        

    }
}