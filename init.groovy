pipelineJob('pipeline2') {
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

pipelineJob('pipeline1') {
    displayName('Pipeline 1')
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
            scriptPath('pipelines/pipeline1')
        }
    }
}

multibranchPipelineJob('Jenkinsfile Pipeline') {
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
