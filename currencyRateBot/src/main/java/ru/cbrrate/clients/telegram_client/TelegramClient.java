package ru.cbrrate.clients.telegram_client;

import ru.cbrrate.model.GetUpdatesRequest;
import ru.cbrrate.model.GetUpdatesResponse;
import ru.cbrrate.model.SendMessageRequest;


public interface TelegramClient {

    GetUpdatesResponse getUpdates(GetUpdatesRequest request);

    void sendMessage(SendMessageRequest request);
}
