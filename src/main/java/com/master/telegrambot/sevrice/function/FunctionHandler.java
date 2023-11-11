package com.master.telegrambot.sevrice.function;

import com.master.telegrambot.api.AirVisualAPI;
import com.master.telegrambot.api.InfoFromAirVisualApi;
import com.master.telegrambot.sevrice.Location.LocationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class FunctionHandler {
    private final LocationHandler locationHandler;
    private final AirVisualAPI airVisualAPI;
    private final AQIFunction aqiFunction;
    private final TemperatureFunciton temperatureFunciton;

    HashMap<Long, Function> functionCat = new HashMap<Long, Function>();

    public void setFunctionCat(Long chaId, Function funtion) {
        functionCat.put(chaId, funtion);
    }

    public Function getFunction(long chatId) {
        return functionCat.get(chatId);
    }

    public SendMessage useFunction(long chatId) {
        Function function = getFunction(chatId);
        InfoFromAirVisualApi infoFromAirVisualApi = airVisualAPI.sendRequest(locationHandler.getLocationStorage(chatId));

        switch (function) {
            case AQI:
                return aqiFunction.getSendMessage(chatId, infoFromAirVisualApi);
            case TEMPERATURE:
                return temperatureFunciton.getSendMessage(chatId, infoFromAirVisualApi);
        }
        return null;
    }
}
