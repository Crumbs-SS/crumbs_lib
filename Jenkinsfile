pipeline{

    agent any

      tools {
            maven 'maven'
      }

  stages{


      stage("package"){
            steps{
                sh 'mvn clean install'
            }
      }

  }
  post {
          always {
              sh 'mvn clean'
          }
      }

}
