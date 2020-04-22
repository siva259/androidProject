node {
    stage('checkout'){
          checkout([$class: 'GitSCM', branches: [[name: '*/developer']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/pocandroid/androidProject.git']]])
	     }
    stage('Build'){
            sh "./gradlew clean assembleRelease"
	   }
     }	
