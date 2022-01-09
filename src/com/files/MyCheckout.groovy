#!/usr/bin/env groovy
package com.files

class MyCheckout implements Serializable{

def steps;
    MyCheckout(steps)
    {
        this.steps = steps
    }

    def git_Checkout(git_url){
        steps.deleteDir()
        steps.checkout([$class: 'GitSCM', branches: [[name: 'main']], extensions: [], userRemoteConfigs: [[credentialsId: 'Git-Hub-cred', url:"${git_url}"]]])
    } 

}