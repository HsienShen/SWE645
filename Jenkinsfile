//Author: Hsien-Tien Shen & Naurmi Varma
// This file contains the credentials and the neccessary commands to run jenkins pipeline
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

		stage("Deploy docker image to the kube cluster"){
            steps{
                sh("kubectl set image deployment/assignment2 container-0=hshen2/studentsurvey645:${BUILD_TIMESTAMP} -n default")
            }
        }
        

    }
}
