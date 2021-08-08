package at.cb.asyncservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class MessagesApiService {
    public List<String> loadMessages(int lastMessages){
        try {
            Thread.sleep(lastMessages*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return List.of(""+lastMessages);
//        return new ArrayList<>();
    }

    public Future<List<String>> loadMessagesAsync(int lastMessages){
        CompletableFuture<List<String>> futureMessages = new CompletableFuture<>();
        new Thread(() -> {
            List<String> messages = loadMessages(lastMessages);
            futureMessages.complete(messages);
        }).start();
        return futureMessages;
    }
}
