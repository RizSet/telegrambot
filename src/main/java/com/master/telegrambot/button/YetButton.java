package com.master.telegrambot.button;

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
public class YetButton {
    private final MessageBuilder messageBuilder;


    public SendMessage getSendMessage(long chatId) {
        SendMessage sendMessage = messageBuilder.getSendMessage(chatId, getMessage(), getButtons());
        return sendMessage;
    }

    public String getMessage() {
        return "Яку ще інформацію ви хочете отримати?";
    }

    public InlineKeyboardMarkup getButtons() {
        List<InlineKeyboardButton> rowButton1 = Stream.of("Якість повітря AQI")
                .map(it -> InlineKeyboardButton.builder().text(it).callbackData("AQI").build())
                .collect(Collectors.toList());
        List<InlineKeyboardButton> rowButton2 = Stream.of("Радіаційний фон")
                .map(it -> InlineKeyboardButton.builder().text(it).callbackData("XRAY").build())
                .collect(Collectors.toList());
        List<InlineKeyboardButton> rowButton3 = Stream.of("Поточна температура повітря")
                .map(it -> InlineKeyboardButton.builder().text(it).callbackData("temperature").build())
                .collect(Collectors.toList());

        InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(rowButton1))
                .keyboard(Collections.singleton(rowButton2))
                .keyboard(Collections.singleton(rowButton3))
                .build();

        return keyboard;
    }
}
