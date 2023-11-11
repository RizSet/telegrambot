package com.master.telegrambot;

import com.master.telegrambot.botconfig.BotConfig;
import com.master.telegrambot.button.ButtonHandler;
import com.master.telegrambot.button.ClearButton;
import com.master.telegrambot.comand.CommandHandler;
import com.master.telegrambot.sevrice.function.FunctionHandler;
import com.master.telegrambot.sevrice.Location.LocationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private final BotConfig botConfig;
    private final CommandHandler commandHandler;
    private final ButtonHandler buttonHandler;
    private final FunctionHandler functionHandler;
    private final LocationHandler locationHandler;
    private final ClearButton clearButton;

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }



    @Override
    public void onUpdateReceived(Update update) {
        long chatId = 0;

        if (update.hasMessage()) {
            Message message = update.getMessage();
            chatId = update.getMessage().getChatId();

            if (message.hasLocation()) {
//                sendMessage(clearButton.getSendMessage(chatId));
//                sendMessage(SendMessage.builder().chatId(chatId).text("!!!").replyMarkup(new ReplyKeyboardRemove()).build());

                Location location = message.getLocation();
                locationHandler.setLocationCat(chatId, location);
                sendMessage(functionHandler.useFunction(chatId));
                return;
            }

            SendMessage sendMessage = commandHandler.getSendMessage(chatId, message.getText());
            sendMessage(sendMessage);

        } else if (update.hasCallbackQuery()) {
            String button = update.getCallbackQuery().getData();
            chatId = update.getCallbackQuery().getFrom().getId();

            SendMessage sendMessage = buttonHandler.getSendMessage(chatId, button);
            sendMessage(sendMessage);
        }
    }

    private void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
        }
    }

}
