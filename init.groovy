pipelineJob('pipeline2') {
    displayName: 'Pipeline 2'
    parameters {
        choiceParam('BRANCH', ['master', 'stable'])
    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/martinhoefling/jenkinspipelines.git','*/${BRANCH}')
            }
            scriptPath('pipelines/pipeline2')
        }
    }
}
