def call(version,outputFile,repoName,groupId,artifactId, extension){
  def NEXUS_URL = "http://172.31.38.236:8081"
  groupId = groupId.replace(".","/")
  echo groupId
  withCredentials([usernameColonPassword(credentialsId: '5a7f8600-4b51-42ce-ab7a-4112ae9e8a73',variable:'USERPASS')]) {
    sh """
    curl -u $USERPASS -o ${outputFile} -X GET "${NEXUS_URL}/repository/${repoName}/${groupId}/${artifactId}/${version}/mvn-demo-${version}.${extension}"
  """ }
}

//  curl -u admin:admin -o ${outputfile} -X GET "${NEXUS_URUL}/repository/doctor-online-release/in/javahome/doctor-online/${version}/doctor-online-${version}.war"
