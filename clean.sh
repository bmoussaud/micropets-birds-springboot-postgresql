#!/bin/bash

kubectl delete -f config/workload.yaml
kubectl delete -f config/app-operator
gh repo delete my-birds-svc --confirm