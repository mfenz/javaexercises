package at.cb.kfzteile.service;

import at.cb.kfzteile.dao.WarengruppenDao;
import at.cb.kfzteile.model.Warengruppe;

import java.util.List;
import java.util.Optional;

public class WarengruppenService {
    public static int createWarengruppe(Warengruppe warengruppe){
        return WarengruppenDao.createWarengruppe(warengruppe);
    }

    public static List<Warengruppe> getWarengruppen(){
        return WarengruppenDao.getWarengruppen();
    }

    public static Optional<Warengruppe> getWarengruppeById(int id){
        return WarengruppenDao.getWarengruppeById(id);
    }

}
