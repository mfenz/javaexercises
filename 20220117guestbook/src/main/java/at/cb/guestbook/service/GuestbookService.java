package at.cb.guestbook.service;

import at.cb.guestbook.dao.GuestbookEntryDao;
import at.cb.guestbook.model.GuestbookEntry;
import at.cb.guestbook.servlet.GuestbookServlet;

import java.util.List;

public class GuestbookService {
    public static int createGuestbookEntry(String name, String email, String text) throws ServiceException {
        // Parameterüberprüfung
        if(name.isBlank()){
            throw new ServiceException("Name is empty");
        }
        if(email.isBlank()){
            throw new ServiceException("Email is empty");
        }
        // a@b.c
        // email muss mind. 5 Zeichen haben und @ enthalten
        if(email.trim().length() < 5 || !email.contains("@")){
            throw new ServiceException("Invalid email");
        }
        if(text.isBlank()){
            throw new ServiceException("Message is empty");
        }

        // Über DAO in die Datenbank
        int id = GuestbookEntryDao.createGuestbookEntry(new GuestbookEntry(0, name, email, text));

        return id;
    }

    public static List<GuestbookEntry> getGuestbookEntries(){
        return GuestbookEntryDao.getGuestbookEntries();
    }
}
