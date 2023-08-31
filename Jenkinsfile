// node{
//   stage('SCM Checkout'){
//     git 'https://github.com/TestCyborg/TestingLab.git'
//   }
//   stage('Compile-Package'){
//     // Get maven home path
//     def mvnHome = tool name: 'TestMaven', type: 'maven'
//     sh "${mvnHome}/bin/mvn package"
//   }
// }
pipeline {
  agent any
  tools {
    maven 'maven-3.8.6'
  }
  stages {
    stage('SCM Checkout'){
      git 'https://github.com/TestCyborg/TestingLab.git'
    }
    stage ('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}
