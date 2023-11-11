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
public class AQIFunction {
    private final MessageBuilder messageBuilder;

    public SendMessage getSendMessage(long chatId, InfoFromAirVisualApi infoFromAirVisualApi) {
        int aqius = infoFromAirVisualApi.getData().getCurrent().getPollution().getAqius();
        return messageBuilder.getSendMessage(chatId, getMessage(aqius), getButtons());
    }

    public String getMessage(int aqius) {
        return "Інформація щодо забруднення повітря,   AQI:\n" + aqius;
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
