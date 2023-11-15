package com.master.telegrambot.button;

import com.master.telegrambot.sevrice.function.Function;
import com.master.telegrambot.sevrice.function.FunctionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

@Service
@RequiredArgsConstructor
public class COButton {
    private final FunctionHandler functionHandler;


    public SendMessage getSendMessage(long chatId) {
        functionHandler.setFunctionCat(chatId, Function.SO2);
        return SendMessage.builder()
                .chatId(chatId)
                .text(getMessage())
                .replyMarkup(getButtonsK())
                .build();
    }

    public String getMessage() {
        return "ТУТ нужны критерии про SO2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }


    public ReplyKeyboardMarkup getButtonsK(){

        KeyboardButton build = KeyboardButton.builder().requestLocation(true).text("Поділитися моїм місцезнаходженням").build();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(build);
        ReplyKeyboardMarkup keyboard = ReplyKeyboardMarkup
                .builder()
                .resizeKeyboard(true)
                .keyboardRow(row1)
                .build();

        return keyboard;
    }
}
