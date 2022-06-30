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

def checkoutCommitHash() {
    node {
        sh 'GIT_COMMIT=ee7145ae6c0d2efe66405d5a490d1825b07ae9d4'
        echo "GIT_COMMIT is: "
        echo env.GIT_COMMIT
    }
}

pipeline {
    agent any
    
    parameters { choice(name: 'COMMITS', choices: getAllCommits(), description: 'Please Select One Commit') }
    
    stages {

        stage('Init') {
            steps {
                checkoutCommitHash()
            }
        }

        stage('Example') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Brain2life/portfolio.git'
                
                script {
                    // echo "You selected the following commit: " 
                    // echo "${params.COMMITS}"
                    // helloWorld()
                    sh 'ls -al'
                }
            }
        }

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