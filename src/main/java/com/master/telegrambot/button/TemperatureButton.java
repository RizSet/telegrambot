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
public class TemperatureButton {
    private final FunctionHandler functionHandler;


    public SendMessage getSendMessage(long chatId) {
        functionHandler.setFunctionCat(chatId, Function.TEMPERATURE);
        return SendMessage.builder()
                .chatId(chatId)
                .text(getMessage())
                .replyMarkup(getButtonsK())
                .build();
    }

    public String getMessage() {
        return "+41...+50 Пустельна спека\n" +
                "+32...+40Середня спека\n" +
                "+29...+32 Комфортна спека \n" +
                "+20...+28 Теплота\n" +
                "+12...+20 Прохолода\n" +
                "+7...+11   Середній холод\n" +
                "0...+6        Зимовий холод\n" +
                "0...-9         Легкий мороз\n" +
                "-10...-20   Середній мороз\n" +
                "-21...-30   Сильний мороз\n" +
                "-31...-40   Жорсткий мороз\n\n" +
                "Для того щоб отримати інформацію требанадати доступ до Вашего місцезнаходження";
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
