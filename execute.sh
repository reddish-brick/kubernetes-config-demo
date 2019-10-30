#!/bin/bash
createImageAndPushToDockerHub(){
  ./gradlew clean build && docker build -t kubernetes-demo:0.1 .
  docker tag kubernetes-demo:0.1 18271959943/kubernetes-demo:0.1
  docker login #并输入用户名18271959943和密码
  docker push 18271959943/kubernetes-demo:0.1
}

applySecret(){
  if [ -f mysql-secrets.yaml ]; then
      kubectl apply -f mysql-secrets.yaml
  fi
  if [ -f kubernetes-config-test-secrets.yaml ]; then
      kubectl apply -f kubernetes-config-test-secrets.yaml
  fi
}

applyConfigMap(){
  if [ -f mysql-config-map.yaml ]; then
      kubectl apply -f mysql-config-map.yaml
  fi
  if [ -f kubernetes-config-test-config-map.yaml ]; then
      kubectl apply -f kubernetes-config-test-config-map.yaml
  fi
}

applyVolumeClaim(){
   if [ -f mysql-volume-claim.yaml ]; then
      kubectl apply -f mysql-volume-claim.yaml
   fi
}

applyMysqlDeployment(){
   if [ -f mysql-deployment.yaml ]; then
    kubectl apply -f mysql-deployment.yaml
   fi
}

applyApplicationDeployment(){
   if [ -f kubernetes-demo-deployment.yaml ]; then
    kubectl apply -f kubernetes-demo-deployment.yaml
   fi
}

applyApplicationService(){
   if [ -f kubernetes-demo-service.yaml ]; then
    kubectl apply -f kubernetes-demo-service.yaml
   fi
}

createImageAndPushToDockerHub

cd ./kubernetes-demo-deployment

applySecret

applyConfigMap

applyVolumeClaim

applyMysqlDeployment

applyApplicationDeployment

applyApplicationService
