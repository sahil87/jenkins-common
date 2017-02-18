#!/usr/bin/groovy
package cc.sahil87

def pushTag(String releaseVersion){
  sh "git tag -fa v${releaseVersion} -m 'Release version ${releaseVersion}'"
  sh "git push origin v${releaseVersion}"
}

def checkUtilsPresent() {
  echo "Present in utils"
}

def printEnvVars() {
  echo sh(returnStdout: true, script: 'env')
}
