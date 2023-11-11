package com.master.telegrambot.button;

import com.master.telegrambot.sevrice.function.Function;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

@Service
public class ClearButton {

    public SendMessage getSendMessage(long chatId) {
        return SendMessage.builder()
                .chatId(chatId)
                .text("")
                .replyMarkup(getButtonsK())
                .build();
    }
    public ReplyKeyboardMarkup getButtonsK(){
        ReplyKeyboardMarkup keyboard = ReplyKeyboardMarkup
                .builder()
                .clearKeyboard()
                .build();
        return keyboard;
    }
}
