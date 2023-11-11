package com.master.telegrambot.sevrice.Location;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Location;

import java.util.HashMap;

@Service
public class LocationHandler {
    HashMap<Long, LocationStorage> locationCat = new HashMap<Long, LocationStorage>();

    public void setLocationCat(Long chaId, Location location){
        LocationStorage locationStorage = LocationStorage.builder()
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
        locationCat.put(chaId, locationStorage);
    }

    public LocationStorage getLocationStorage(long chatId) {
        return  locationCat.get(chatId);
    }

}
