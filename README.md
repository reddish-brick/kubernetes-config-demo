#### kubernetes-dashboard

* create kubernetes-dashboard
~~~
kubectl apply -f kubernetes-dashboard.yaml
~~~
* delete kubernetes-dashboard
~~~
kubectl delete -f kubernetes-dashboard.yaml
~~~
* view the port of the kubernetes-dashboard
~~~
kubectl get service -n kube-system
~~~

#### init the application
locate to the root directory and execute the following shell script
~~~
./execute.sh
~~~