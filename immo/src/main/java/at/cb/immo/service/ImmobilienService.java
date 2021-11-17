package at.cb.immo.service;

import at.cb.immo.dao.ImmobilieDAO;
import at.cb.immo.model.Immobilie;

import java.util.List;
import java.util.Optional;

public class ImmobilienService {
    public static int createImmobilie(String typ,
                                      String adresse,
                                      float kaufpreis){
        return ImmobilieDAO.createImmobilie(typ, adresse, kaufpreis, "");
    }

    public static List<Immobilie> getImmobilien(){
        return ImmobilieDAO.getImmobilien();
    }

    public static Optional<Immobilie> getImmobilieById(int id){
        return ImmobilieDAO.getImmobilieById(id);
    }

    public static void updateImmobilie(Immobilie immo){
        ImmobilieDAO.update(immo);
    }
}
