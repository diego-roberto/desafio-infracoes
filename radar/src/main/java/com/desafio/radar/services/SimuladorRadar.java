package com.desafio.radar.services;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class SimuladorRadar {

    private static final String INFRACAO_API_URL = "http://localhost:8080/infracoes";

    @PostConstruct
    public void startSimulation() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(() -> {
            try {
                JSONObject infracaoJson = createInfracaoJson();
                HttpPost request = new HttpPost(INFRACAO_API_URL);
                request.setEntity(new StringEntity(infracaoJson.toString(), ContentType.APPLICATION_JSON));

                try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                    httpClient.execute(request);
                    System.out.println("Enviando infração: "+ infracaoJson);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS);
    }

    private JSONObject createInfracaoJson() {
        Random random = new Random();
        int speed = random.nextInt(21) + 80;
        String placa = generateRandomPlaca();
        String veiculo = generateRandomVeiculo();

        JSONObject infractionJson = new JSONObject();
        infractionJson.put("datahora", LocalDateTime.now());
        infractionJson.put("velocidade", speed);
        infractionJson.put("placa", placa);
        infractionJson.put("veiculo", veiculo);

        return infractionJson;
    }

    private String generateRandomPlaca() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        sb.append(letras.charAt(random.nextInt(letras.length())));
        sb.append(letras.charAt(random.nextInt(letras.length())));
        sb.append(letras.charAt(random.nextInt(letras.length())));
        sb.append(numeros.charAt(random.nextInt(numeros.length())));
        sb.append(letras.charAt(random.nextInt(letras.length())));
        sb.append(numeros.charAt(random.nextInt(numeros.length())));
        sb.append(numeros.charAt(random.nextInt(numeros.length())));

        return sb.toString();
    }

    private String generateRandomVeiculo() {
        String[] vehicleClasses = {"CARRO", "MOTOCICLETA", "CAMINHAO", "ONIBUS"};
        Random random = new Random();
        int index = random.nextInt(vehicleClasses.length);
        return vehicleClasses[index];
    }

}
