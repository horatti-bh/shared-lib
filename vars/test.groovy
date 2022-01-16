def info(message) {
    echo "INFO: ${message}"
}

def warnings(message) {
    echo "WARNINGS: ${message}"
}

def call() {
    pipeline {
        agent any
        stages {
            stage ('test_lib') {
                steps {
                 sh '''
                    echo Hello word
                    '''
                }
            }
        }
    }
}