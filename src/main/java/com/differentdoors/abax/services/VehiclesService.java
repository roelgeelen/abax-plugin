package com.differentdoors.abax.services;

import com.differentdoors.abax.models.AResults;
import com.differentdoors.abax.models.objects.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class VehiclesService {

    @Autowired
    @Qualifier("Abax")
    private WebClient webClient;

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .build();

    public AResults<Vehicle> getVehicles() throws Exception {
        return objectMapper.readValue(webClient.get()
                .uri("/v1/vehicles")
                .retrieve()
                .bodyToMono(String.class)
                .block(), new TypeReference<>() {});
    }
}
