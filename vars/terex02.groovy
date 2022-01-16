def call (PLANRUN=true) {
    pipeline {
        agent any
        stages {
            stage('terraform_init_check') {
                steps {
                    sh '''
                   terraform init
                   '''
                }
            }


            stage('terraform_plan_check') {
                when {
                    expression {
                        return PLANRUN
                    }
                }

                steps {
                    sh '''
                        terraform plan
                        '''
                }
            }
        }
    }
}