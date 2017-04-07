folder('pipeline') {
    displayName('Pipeline Jobs')
    description('A folder containing pipelines')
}

pipelineJob('pipeline/pipeline1') {
    displayName('Pipeline 1')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        name('origin')
                        url('https://github.com/martinhoefling/jenkinspipelines.git')
                    }
                    branch('*/master')
                }
            }
            scriptPath('pipelines/pipeline1')
        }
    }
}

pipelineJob('pipeline/pipeline2') {
    displayName('Pipeline 2 (master/stable)')
    parameters {
        choiceParam('BRANCH', ['master', 'stable'])
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        name('origin')
                        url('https://github.com/martinhoefling/jenkinspipelines.git')
                    }
                    branch('*/${BRANCH}')
                }
            }
            scriptPath('pipelines/pipeline2')
        }
    }
}

multibranchPipelineJob('pipeline/jenkinsfile') {
    displayName('Jenkinsfile Pipeline')
    branchSources {
        git {
            remote('https://github.com/martinhoefling/jenkinspipelines.git')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}
