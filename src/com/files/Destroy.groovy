#!/usr/bin/env groovy
package com.files

class Destroy implements Serializable{
   def steps;
   Destroy(steps)
   {
       this.steps = steps;
   }

   def terraform_destroy(tool,choice,myVar){
       steps.withCredentials([[
                $class: 'AmazonWebServicesCredentialsBinding',
                 credentialsId: "22bb0d03-56cf-41f6-9c69-dd86d3f3f9b9",
                accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                  secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                     
            
                     steps.sh "${tool}/terraform ${choice} -var-file=${myVar} -auto-approve"
                      }
   }

}
