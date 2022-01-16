def call () {
    pipeline {
        agent any
        stages {
            stage ('terraform_init_check') {
                steps {
                 sh '''
                   terraform init
                   '''
                    }
                }
            }

            stage ('terraform_plan_check') {
                steps {
                    sh '''
                        terraform plan
                        '''
                    }
                }
            }
        }