node{
  stages{
     stage('Git Checkout'){
	     checkout SCM
		 }
	 stage('Gradle build'){
         sh "./gradlew clean assembleRelease"
         }
    }	
}	
