package dev.bootcamp.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Servidor de configuración centralizada de los microservicios del banco.
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    /**
     * Arranca el servidor de configuración.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
