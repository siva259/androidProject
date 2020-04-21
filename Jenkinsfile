node {
     stages{
         stage('Git Checkout'){
             steps {
		  checkout SCM
	        }
	    }
	   stage('Gradle build'){
	        steps {
                     sh "./gradlew clean assembleRelease"
	          }
            }
       }	
 }	
