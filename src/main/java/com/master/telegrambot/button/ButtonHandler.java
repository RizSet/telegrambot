package com.master.telegrambot.button;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ButtonHandler {

    private final AQIButton aqiButton;
    private final YetButton yetButton;
    private final TemperatureButton temperatureButton;

    public SendMessage getSendMessage(long chatId/*, int messageId*/, String button) {
        switch (button) {
            case "AQI":
                return aqiButton.getSendMessage(chatId);
            case "XRAY":
                return aqiButton.getSendMessage(chatId);
            case "temperature":
                return temperatureButton.getSendMessage(chatId);
            case "yet":
                return yetButton.getSendMessage(chatId);
            default:
                return null;
        }
    }
}
