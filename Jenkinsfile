node {
     stages {
         stage('checkout'){
             steps {
		  checkout SCM
	        }
	    }
	   stage('Build'){
	        steps {
                     sh "./gradlew clean assembleRelease"
	          }
            }
       }	
 }	
