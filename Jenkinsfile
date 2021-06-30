pipeline{

    agent any

      tools {
            maven 'maven'
            java 'java'
      }

  stages{


      stage("package"){
            steps{
                sh 'mvn clean install'
            }
      }

  }
//   post {
//           always {
//               sh 'mvn clean'
//           }
//       }

}
