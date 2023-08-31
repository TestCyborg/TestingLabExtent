node{
  tools {
    maven 'maven-3.8.6'
  }
//   stages{
    stage('SCM Checkout'){
        git 'https://github.com/TestCyborg/TestingLabExtent.git'
      }
      stage('Compile-Package'){
        // Get maven home path
        def mvnHome = tool name: 'TestMaven', type: 'maven'
        sh "${mvnHome}/bin/mvn package"
//         steps {
//                 sh 'mvn package'
//               }
      }
//   }
}
// pipeline {
//   agent any
//   tools {
//     maven 'maven-3.8.6'
//   }
//   stages {
//     stage('SCM Checkout'){
//       git 'https://github.com/TestCyborg/TestingLabExtent.git'
//     }
//     stage ('Build') {
//       steps {
//         sh 'mvn package'
//       }
//     }
//   }
// }