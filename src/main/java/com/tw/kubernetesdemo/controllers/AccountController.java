package com.tw.kubernetesdemo.controllers;

import com.tw.kubernetesdemo.configuration.MyConfig;
import com.tw.kubernetesdemo.models.Account;
import com.tw.kubernetesdemo.repository.AccountRepository;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.client.KubernetesClient;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private MyConfig config;

  @Autowired
  private KubernetesClient kubernetesClient;

  @GetMapping
  public List<Account> findAll() {
    return accountRepository.findAll();
  }

  @GetMapping("/secret")
  public ResponseEntity<String> secret() {
    return ResponseEntity
        .ok()
        .body(getSecretDataFromKubernetes("kubernetes-config-test", "default"));
  }

  @GetMapping("/configMap")
  public ResponseEntity<String> configMap() {
    return ResponseEntity
        .ok()
        .body(getConfigMapDataFromKubernetes("kubernetes-demo", "default"));
  }

  private String getConfigMapDataFromKubernetes(String configMapName, String namespace) {
    ConfigMap configMap = kubernetesClient.configMaps().inNamespace(namespace)
        .withName(configMapName).get();
    Map<String, String> configMapData = configMap.getData();
    return format("configMap: username--%s,password--%s,account-name--%s", config.getUsername(), config.getPassword(), configMapData.get("account-name"));
  }

  private String getSecretDataFromKubernetes(String secretName, String namespace) {
    Secret secret = kubernetesClient.secrets().inNamespace(namespace)
        .withName(secretName).get();
    Map<String, String> secretDataMap = secret.getData();
    Decoder decoder = Base64.getDecoder();
    String username = new String(decoder.decode(secretDataMap.get("username")), StandardCharsets.UTF_8);
    String password = new String(decoder.decode(secretDataMap.get("password")), StandardCharsets.UTF_8);
    return String.format("secret: username--%s,password--%s", username, password);
  }
}
