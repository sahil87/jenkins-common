#!/usr/bin/groovy
package cc.sahil87

def pushTag(String releaseVersion){
  sh "git tag -fa v${releaseVersion} -m 'Release version ${releaseVersion}'"
  sh "git push origin v${releaseVersion}"
}

def pingUtils() {
  echo "Present in utils"
}

def printEnvVars() {
  echo sh(returnStdout: true, script: 'env')
}

def getNpmVer() {
  return (sh (returnStdout: true, script: "node -e \"console.log(require('./package.json').version)\"")).trim()
}

def incNpmVer(String sshAgentName) {
  def newVersion
  sshagent([sshAgentName]) {
    def newTag = (sh (returnStdout: true, script: "npm version patch")).trim()
    sh "git push origin ${newTag}"
    return newTag
  }
}

def pushTag(String releaseVersion, String sshAgentName) {
  sshagent([sshAgentName]) {
    sh "git tag -fa v${releaseVersion} -m 'Release version ${releaseVersion}'"
    sh "git push origin v${releaseVersion}"
  }
}

def configureGit(userName, userEmail) {
  sh("git config push.default simple")
  sh("git config user.name ${userName}")
  sh("git config user.email ${userEmail}")
}
