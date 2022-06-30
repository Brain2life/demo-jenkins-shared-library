#!/usr/bin/env groovy
@Library("shared-library") _

def getAllCommits() {
    node {
        def commits = sh (
        script: "git log --format=format:%H",
        returnStdout: true
    ).split(/\r?\n/) as List
    return commits
    }
}

// def checkoutCommitHash() {
//         echo "Parameter COMMIT: "
//         echo ${params.COMMIT}
//         // sh 'git checkout -f '${params.COMMIT}''
//         sh 'ls -al'
//         // sh 'env.GIT_COMMIT="8ac39edd805c36136e8e32b5c414adac3d0f2ae9"'
//         // echo "GIT_COMMIT is: "
//         // echo env.GIT_COMMIT
// }

pipeline {
    agent any
    
    parameters { choice(name: 'COMMIT', choices: getAllCommits(), description: 'Please Select One Commit') }
    
    stages {

        // stage('Init') {
        //     steps {
        //         checkoutCommitHash()
        //     }
        // }

        stage('One') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Brain2life/test-jenkins.git'

                script {
                    echo "GIT_COMMIT"
                    echo env.GIT_COMMIT

                    // echo "Parameter COMMIT: "
                    // echo "${params.COMMIT}"

                    sh 'git checkout -f ' + "${params.COMMIT}"
                    sh 'ls -al'   
                }


                // checkoutCommitHash()

                // script {
                    // echo "You selected the following commit: " 
                    // echo "${params.COMMITS}"
                    // helloWorld()
                    // sh 'ls -al'
                    // sh 'git show README.md'
                // }
            }
        }

        stage('Two') {
            steps {

                script {
                    echo "GIT_COMMIT"
                    echo env.GIT_COMMIT

                    // echo "Parameter COMMIT: "
                    // echo "${params.COMMIT}"

                    sh 'ls -al'   
                    sh 'cat README.md'
                }


                // checkoutCommitHash()

                // script {
                    // echo "You selected the following commit: " 
                    // echo "${params.COMMITS}"
                    // helloWorld()
                    // sh 'ls -al'
                    // sh 'git show README.md'
                // }
            }
        }
        // stage('Init') {
        //     steps {
        //         checkoutCommitHash()

        //         script {
        //             sh 'ls -al'
        //         }
        //     }
        // }

        // stage('Checkout commit') {
        //     steps {
        //         git branch: 'main',
        //         url: 'https://github.com/Brain2life/portfolio.git'

        //         script {
        //             echo 'Checkout specific commit:'
        //             echo "${params.COMMITS}"
        //             sh 'git checkout ' + "${params.COMMITS}"
        //             sh 'ls -al'
        //             sh 'git show ' + "${params.COMMITS}"
        //         }
        //     }
        // }
    }
}