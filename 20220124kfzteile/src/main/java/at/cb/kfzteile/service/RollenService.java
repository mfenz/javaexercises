package at.cb.kfzteile.service;

import at.cb.kfzteile.dao.RollenDao;
import at.cb.kfzteile.model.Rolle;

import java.util.Optional;

public class RollenService {
    public static Optional<Rolle> getRolleById(int id){
        return RollenDao.getRolleById(id);
    }

    public static void deleteBenutzerRollenByBenutzerId(int benutzerId){
        RollenDao.deleteBenutzerRollenByBenutzerId(benutzerId);
    }
}
