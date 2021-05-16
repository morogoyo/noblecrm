pipeline {
//   parameters {
//       string(name: 'st_build_number', defaultValue: 'latest', description: 'The tag that will be used to tag the docker image', trim: true)
//       string(name: 'st_git_branch', defaultValue: 'develop', description: 'The git branch or tag that should be build', trim: true)
//   }
//   environment {
//     dockerRegistry = "https://dockerhub.com"
//     dockerImageTag = "morogoyo/noble-crm-backend:latest"
//     dockerRegistryCredential = 'DockerHubCreds'
//     gitCredentials = 'git-read-only'
//     gitRepository = "git@github.com:morogoyo/noblecrm.git"
//     dockerImage = ''
//   }
  agent any
  tools {
          maven 'maven-3.6'
        }
  stages {
    stage('Cloning Git') {
      steps {
          git branch: 'develop', credentialsId: 'git-hub-ssh-user', url: 'git@github.com:morogoyo/noblecrm.git'
      }
    }
    stage('Maven clean install'){
       steps{
        sh 'mvn clean install -DskipTests=true'
        sh 'mvn package -DskipTests=true'
       }
    }
//     stage('Building image') {
//       steps{
//         script {
//                 dockerImage = docker.build dockerImageTag
//             }
//         }
//       }
//     }
    stage('Deploy Image to Docker Registry') {
      steps{
        script {
            docker.withRegistry( dockerRegistry, dockerRegistryCredential ) {
                dockerImage.push()
            }
        }
//       }
//     }
//     stage('Remove Unused docker image') {
//       steps{
//         sh "docker rmi $dockerImageTag"
//       }
//     }
//   }

}
}
}
