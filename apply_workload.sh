
tanzu apps workload apply -f config/workload.yaml --live-update --local-path . --source-image akseutap4registry.azurecr.io/micropet-tap-birds-sources --namespace micropets-dev --yes 

