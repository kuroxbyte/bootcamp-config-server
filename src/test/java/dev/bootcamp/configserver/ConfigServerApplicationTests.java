package dev.bootcamp.configserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestClient;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Verifica que el servidor sirva la configuración del repositorio config-repo.
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.cloud.config.server.git.uri=file:../config-repo")
class ConfigServerApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    void servesConfigurationOfEachService() {
        String body = RestClient.create("http://localhost:" + port)
                .get()
                .uri("/account-service/default")
                .retrieve()
                .body(String.class);

        assertThat(Path.of("../config-repo/account-service.yaml")).exists();
        assertThat(body).contains("clients.customer-service.base-url", "server.port");
    }
}
