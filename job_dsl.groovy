pipelineJob('k8s-deployment') {

  def repo = 'https://github.com/madhav411/helm-values.git'

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

  def repo = 'https://github.com/madhav411/docker-trigger.git'

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
