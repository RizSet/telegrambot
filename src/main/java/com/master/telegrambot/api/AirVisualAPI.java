package com.master.telegrambot.api;

import com.google.gson.Gson;
import com.master.telegrambot.sevrice.Location.LocationStorage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AirVisualAPI {
    public InfoFromAirVisualApi sendRequest(LocationStorage locationStorage) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://api.airvisual.com/v2/nearest_city?" +
                "lat=" + locationStorage.getLatitude() +
                "&lon=" + locationStorage.getLongitude() +
                "&key=a69a161a-e4b5-4fd0-a086-947d6e4b5c5d");
        try {
            HttpResponse response = httpClient.execute(httpGet);
            byte[] bytes = response.getEntity().getContent().readAllBytes();
            String json = new String(bytes);
            return new Gson().fromJson(json, InfoFromAirVisualApi.class);

//            System.out.println(infoFromAirVisualApi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
