pipelineJob('pipeline2') {
    displayName('Pipeline 2')
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
