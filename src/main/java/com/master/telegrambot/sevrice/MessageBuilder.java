package com.master.telegrambot.sevrice;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;

@Service
public class MessageBuilder {
    public SendMessage getSendMessage(long chatId, String text, InlineKeyboardMarkup buttons){
        SendMessage result = new SendMessage();
        result.setChatId(chatId);
        result.setText(text);
        result.setReplyMarkup(buttons);
        return result;
    }
}
