def terraformInit() {
    def execute_state=sh(returnStdout: true, script: "terraform init")
    println execute_state
}