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

pipeline {
    agent any
    
    parameters { choice(name: 'COMMITS', choices: getAllCommits(), description: 'Please Select One Commit') }
    
    stages {
        stage('Example') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Brain2life/portfolio.git'
                
                script {
                    echo "You selected the following commit: " 
                    echo "${params.COMMITS}"
                    helloWorld()
                }
            }
        }

        stage('Checkout commit') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Brain2life/portfolio.git'

                script {
                    echo 'Checkout specific commit:'
                    echo "${params.COMMITS}"
                    sh 'git checkout ' + "${params.COMMITS}"
                    sh 'ls -al'
                }
            }
        }
    }
}