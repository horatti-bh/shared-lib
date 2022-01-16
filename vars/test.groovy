def info(message) {
    echo "INFO: ${message}"
}

def warnings(message) {
    echo "WARNINGS: ${message}"
}

def URL1 = shared.com

def call() {
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