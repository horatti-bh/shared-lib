def call(Map params = [:]) {
    def args = [
            INIT : true,
            PLAN : false.
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
            stage(Terraform INIT) {
                steps {
                    sh '''
//                  terraform init or
                    make init         
                    '''
                }
            }
        }
    }
}