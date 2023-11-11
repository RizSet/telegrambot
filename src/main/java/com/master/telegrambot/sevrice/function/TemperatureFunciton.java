package com.master.telegrambot.sevrice.function;

import com.master.telegrambot.api.InfoFromAirVisualApi;
import com.master.telegrambot.sevrice.MessageBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TemperatureFunciton {
    private final MessageBuilder messageBuilder;
    public SendMessage getSendMessage(long chatId, InfoFromAirVisualApi infoFromAirVisualApi) {
        int temperature = infoFromAirVisualApi.getData().getCurrent().getWeather().getTp();
        return messageBuilder.getSendMessage(chatId, getMessage(temperature), getButtons());
    }

    public String getMessage(int temperature) {
        return "Температура повітря, \u00B0С:\n" + temperature;
    }

    public InlineKeyboardMarkup getButtons() {
        List<InlineKeyboardButton> rowButton1 = Stream.of("Бажаю отримати іншу інформацію")
                .map(it -> InlineKeyboardButton.builder().text(it).callbackData("yet").build())
                .collect(Collectors.toList());

        InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(rowButton1))
                .build();

        return keyboard;
    }
}
