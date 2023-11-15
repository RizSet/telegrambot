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
public class COAPI {
    public InfoFromCOAPI sendRequest(LocationStorage locationStorage) {
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(
                "https://api.waqi.info/feed/geo:" +
                        locationStorage.getLatitude() +
                        ";" +
                        locationStorage.getLongitude() +
                        "/?token=921e2b1b652ef6c4cb19b8a29b4ce3f35cb698bf"
        );

        try {
            HttpResponse response = httpClient.execute(httpGet);
            byte[] bytes = response.getEntity().getContent().readAllBytes();
            String json = new String(bytes);

            return new Gson().fromJson(json, InfoFromCOAPI.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
