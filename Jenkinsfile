pipeline {
    agent { label 'built-in' }
    
    triggers {
        // Poll GitHub every 5 minutes for script changes
        pollSCM('H/5 * * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Deploy Scripts to Controller') {
            steps {
                script {
                    // Define the target directory on the Jenkins controller
                    def targetDir = "/var/jenkins_home/active_choices/scripts"
                    
                    // Create directory if it doesn't exist
                    sh "mkdir -p ${targetDir}"
                    
                    // Copy scripts/data from workspace to the persistent folder
                    // This ensures Active Choices can see them regardless of workspace cleanup
                    sh "cp -r ${WORKSPACE}/metadata/*.json ${targetDir}/"
                }
            }
        }
    }
}
