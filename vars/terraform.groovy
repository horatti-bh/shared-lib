def call(Map params = [:]) {
    def args = [
            INIT : true,
            PLAN : false,
            APPLY : true,
            DESTROY : false
    ]
    args << params

    pipeline {
        agent any
        parameters {
            choice(choices: ['', 'dev', 'prod'], description: 'select env', name: 'ENV')
        }
        stages {
            stage('Terraform INIT') {
                when {
                    expression {
                        return INIT
                    }
                }
                steps {
                    sh '''
                make init-${ENV}   
                    '''
                }
            }
            stage('Terraform PLAN') {
                when {
                    expression {
                        return PLAN
                    }
                }
                steps {
                    sh '''
                make plan-${ENV}   
                    '''
                }
            }
            stage('Terraform APPLY') {
                when {
                    expression {
                        return APPLY
                    }
                }
                steps {
                    sh '''
                make apply-${ENV}   
                    '''
                }
            }
            stage('Terraform DESTROY') {
                when {
                    expression {
                        return DESTROY
                    }
                }
                steps {
                    sh '''
                make destroy-${ENV}   
                    '''
                }
            }
        }
    }
}