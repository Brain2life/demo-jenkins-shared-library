#!/usr/bin/env groovy

/*
Script returns the list of all git commits in the repository branch
*/

def call() {    
    def commits = sh (
        script: "git log --format=format:%H",
        returnStdout: true
    ).split(/\r?\n/) as List
    return commits
}