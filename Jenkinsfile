node {
     stages{
         stage('Checkout'){
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
