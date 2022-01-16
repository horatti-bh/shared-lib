def terraformInit() {
    def execute_state=sh(returnStdout: true, script: "terraform init")
    println execute_state
}

def terraformplan() {
    def output=sh(returnStdout: true, script: "terraform plan ")
}

//def terraformApply() {
//    def output=sh(returnStdout: true, script: "terraform apply -auto-approve ")
//}