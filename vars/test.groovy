def info(message) {
    echo "INFO: ${message}"
}

def warnings(message) {
    echo "WARNINGS: ${message}"
}



def call() {
    URL1 = 'shared.com'
    pipeline {
        agent any
        stages {
            stage ('test_lib') {
                steps {
                 sh '''
                    echo Hello word
                    '''
                    script {
                        info "Hello from info"
                        print URL1
                    }
                }
            }
        }
    }
}