SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='akseutap4registry.azurecr.io/micropet-tap-birds-sources')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='dev-tap')

allow_k8s_contexts('aks-eu-tap-4')

k8s_yaml(["config/app-operator/tanzu-postgresql.yaml"])

k8s_custom_deploy(
    'birds',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --live-update" +
               " --local-path " + LOCAL_PATH +
               " --source-image " + SOURCE_IMAGE +
               " --namespace " + NAMESPACE +
               " --yes >/dev/null" +
               " && kubectl get workload birds-springboot-postgresql --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('birds', port_forwards=["8080:8080"], extra_pod_selectors=[{'app.kubernetes.io/name': 'birds'}]) 