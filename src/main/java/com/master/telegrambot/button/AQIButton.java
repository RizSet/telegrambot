package com.master.telegrambot.button;

import com.master.telegrambot.sevrice.function.Function;
import com.master.telegrambot.sevrice.function.FunctionHandler;
import com.master.telegrambot.sevrice.MessageBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

@Service
@RequiredArgsConstructor
public class AQIButton {

    private final MessageBuilder messageBuilder;
    private final FunctionHandler functionHandler;


    public SendMessage getSendMessage(long chatId) {
        functionHandler.setFunctionCat(chatId, Function.AQI);
        return SendMessage.builder()
                .chatId(chatId)
                .text(getMessage())
                .replyMarkup(getButtonsK())
                .build();
    }

    public String getMessage() {
        return "Критерії оцінки за шкалою AQI US:\n" +
                "0...50 - Добре;\n" +
                "51...100 - Середньо;\n" +
                "101...150 - Шкідливо для вразливих груп;\n" +
                "151...200 - Шкідливо;\n" +
                "201...300 - Дуже шкідливо;\n" +
                "301+        - Небезпечно.\n\n" +
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
