pipelineJob('k8s-deploy') {

  def repo = 'https://github.com/madhav411/app-mono-helmstate.git'

  triggers {
    githubPush()
  }
  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('madhav_github_credentials')
            url(repo)
          }
          branch('master')
          scriptPath('Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}


pipelineJob('image-orchestrator-job') {

  def repo = 'https://github.com/madhav411/app-mono-orchestrator.git'

  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('madhav_github_credentials')
            url(repo)
          }
          branch('master')
          scriptPath('Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}

pipelineJob('app-mono-build-job') {

  def repo = 'https://github.com/madhav411/app-mono.git'

  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('madhav_github_credentials')
            url(repo)
          }
          branch('master')
          scriptPath('Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}
