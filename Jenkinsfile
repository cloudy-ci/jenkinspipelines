#!/usr/bin/groovy
podTemplate(label: 'mongopython', containers: [
        containerTemplate(name: 'jnlp', image: 'jenkinsci/jnlp-slave:2.62-alpine', args: '${computer.jnlpmac} ${computer.name}'),
        containerTemplate(name: 'python', image: 'python', ttyEnabled: true, command: 'cat'),
        containerTemplate(name: 'mongodb', image: 'mongo')
]) {

    node('mongopython') {
        stage 'Install pymongo in python container'
        container('python') {
            stage 'Pip install pymongo'
            sh 'pip install pymongo'
        }

        stage 'Pymongo connect'
        container('python') {
            stage 'Connect to mongodb'
            sh """
            sleep 2
            
            python -c "from pymongo import MongoClient;client = MongoClient('localhost', 27017);print('connected')"
            """
        }

    }
}
