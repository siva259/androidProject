node {
    try{
    stage('checkout'){
         checkout([$class: 'GitSCM', branches: [[name: '*/developer']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/pocandroid/devopsMobility.git']]])
	    }
    stage('Build'){ 
        withGradle{
            sh "chmod +x gradlew"
            sh "./gradlew clean assembleRelease"
           }
      }
    stage('Archeive artifacts'){
	    archiveArtifacts artifacts: '**/*.apk', followSymlinks: false
	}
    stage('Nexus Repository'){	   

	    nexusArtifactUploader artifacts: [[artifactId: 'devops-mobility', classifier: '', file: 'app/build/outputs/apk/release/devops-mobility.apk', type: 'apk']], credentialsId: 'bcebae3d-4df0-4fb2-8ca4-6ee8af37cabb', groupId: 'com.android.devops-dev', nexusUrl: 'localhost:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'devopsmobility', version: '1.1'

	}
    stage('App Center'){	   

	    appCenter apiToken: 'b748b14dd139606b4d1695855315b8789178cd2f', appName: 'dev', distributionGroups: 'pocAndroid', notifyTesters: false, ownerName: 'devopsmobility', pathToApp: 'app/build/outputs/apk/release/*.apk', pathToDebugSymbols: '', pathToReleaseNotes: '', releaseNotes: 'devops-mobility apk stored in appCenter'
	}	

    stage('Publish app GooglePlay'){
           androidApkUpload filesPattern: '**/build/outputs/**/*.apk', googleCredentialsId: 'Google Play Android Developer', recentChangeList: [[language: 'en-GB', text: 'Please test the apk']], trackName: 'production'

	}
	   emailext body: 'Build Success and APK file is successfully pushed Nexus and AppCenter.', subject: 'Build Status', to: 'sivarajac1986@gmail.com,cjaiganesh@gmail.com,ravi265@gmail.com'
    }catch(error){
	 errorDescription= error.getMessage()  
         emailext body: "${errorDescription}", subject: "Build Failure-${currentBuild.fullDisplayName}", to: 'sivarajac1986@gmail.com,cjaiganesh@gmail.com,reddy.ashok4567@gmail.com,ravi265@gmail.com'
         throw(error)	    
    }
 }
