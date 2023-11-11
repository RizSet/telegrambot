package com.master.telegrambot.comand;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
@RequiredArgsConstructor
public class CommandHandler {
    private final StartCommand startCommand;
    public boolean isCommandExist(String command) {
        switch (command) {
            case "/start": return true;
            default: return false;
        }
    }

    public SendMessage getSendMessage(long chatId, String command){
        switch (command) {
            case "/start": return startCommand.getSendMessage(chatId);
            default: return null;
        }
    }
}

