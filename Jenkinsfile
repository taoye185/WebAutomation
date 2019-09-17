pipeline {
    agent any
     	environment{
              branch = "${env.BRANCH_NAME}" 
              def  s3BucketName = 's3://qa-automation-mobeewave'
            def mvnHome = tool 'Maven'  
            def testJarName = null
 	}

    stages {

        stage('Build'){
            steps { 
                    echo 'Acquirer Portal UI Automation Build in progress..'
                    script{                     
                        bat "\"${mvnHome}\"/bin/mvn clean compile test-compile assembly:single -Dv=${BUILD_NUMBER}"          
                    } 
            }
        }
        stage('Run tests'){
            steps { 
                    echo 'Running tests'
                    script{
                        def testJars = findFiles(glob:"**/target/AcquirerPortal*.${BUILD_NUMBER}.jar")
                        testJarName = testJars[0].name
                        bat "\"${JAVA_HOME}\"\\bin\\java -jar  target/${testJarName}"
                    } 
            }
             post {
        always {
            echo 'publishing the cucumber test report and archiving test reports'
            script{
                cucumber buildStatus:"UNSTABLE",
                fileIncludePattern: "cucumber-report.json",
                jsonReportDirectory: 'target/test-reports/'
                 
            }
            echo 'Archiving the test ouput files' 
            script{
            archiveArtifacts "target/test-reports/**,target/*.jar,logs/*.*"
            }
           }
         }        
        }
        stage('Deploy Jar to S3'){
              when {
                branch "master"
            }
            steps { 
                    echo 'Deploying jar file to S3'
                    script{
                    deploytoS3()
                }
            }    
        }                  
    }
     post {
        success{
            deleteDir()
      }
   }
    
}

//Function to deploy jar file to S3
def deploytoS3(){
   bat """aws s3 cp \"${env.WORKSPACE}\"/target/${testJarName} ${s3BucketName}"""
}