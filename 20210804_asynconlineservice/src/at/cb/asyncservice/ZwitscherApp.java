package at.cb.asyncservice;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ZwitscherApp {
    public static void main(String[] args) {
        ZwitscherApp app = new ZwitscherApp();
        app.sync();
    }

    private MessagesApiService api = new MessagesApiService();

    public void sync(){
        List<String> fb = api.loadMessages(3);
        List<String> tw = api.loadMessages(3);
        System.out.println(fb);
        System.out.println(tw);
    }

    public void async(){
        Future<List<String>> messagesFutureFb = api.loadMessagesAsync(3);
        Future<List<String>> messagesFutureTw = api.loadMessagesAsync(3);
        try {
            List<String> fb = messagesFutureFb.get();
            List<String> tw = messagesFutureTw.get();
            System.out.println("ASYNC: ");
            System.out.println(fb);
            System.out.println(tw);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
