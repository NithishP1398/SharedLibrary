def call(version,outputFile,repoName,groupId,artifactId, extension){
  def NEXUS_URL = "http://172.31.38.236:8081"
  groupId = groupId.replace(".","/")
  echo groupId
  sh """
    curl -u admin:admin -o ${outputFile} -X GET "${NEXUS_URL}/repository/${repoName}/${groupId}/${artifactId}/${version}/mvn-demo-${version}.${extension}"
  """
}

//  curl -u admin:admin -o ${outputfile} -X GET "${NEXUS_URUL}/repository/doctor-online-release/in/javahome/doctor-online/${version}/doctor-online-${version}.war"
