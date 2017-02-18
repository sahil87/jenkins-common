# jenkins-common
A set of useful Jenkinsfile methods

### Usage
```
#In Jenkinsfile
@Library('github.com/sahil87/jenkins-common@master')
def utils = new cc.sahil87.Utils()

node {
  stage('Env properties') {
    utils.pingUtils()
    utils.printEnvVars()
  }
}
```
