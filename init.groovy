pipelineJob('pipeline2') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/martinhoefling/jenkinspipelines.git')
            }
            scriptPath('pipelines/pipeline2')
        }
    }
}
