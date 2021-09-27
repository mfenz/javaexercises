package at.cb.testingcms.service;

import at.cb.testingcms.formdata.RegistrationData;
import at.cb.testingcms.model.Role;
import at.cb.testingcms.model.User;
import at.cb.testingcms.repository.RoleRepository;
import at.cb.testingcms.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private RoleRepository roleRepository;

    @BeforeEach
    public void initBeforeEach(){
        // Mock-Objekt für UserRepository erzeugen
        userRepository = Mockito.mock(UserRepository.class);
        // wenn userRepository.save(user) aufgerufen wird, den User zurückgeben
        Mockito
                .when(userRepository.save(Mockito.any(User.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        roleRepository = Mockito.mock(RoleRepository.class);
        Mockito.doReturn(new Role("USER"))
                .when(roleRepository).getById("USER");

        userService = new UserService(userRepository, bCryptPasswordEncoder, roleRepository);
    }

    @Test
    public void wennEmailBeiRegistrierungLeerDannServiceException(){
        RegistrationData  data = new RegistrationData("", "HalloWelt9", "Manfred");
        // Schreibt die ausgelöste ServiceException in eine Variable
        // falls Exception nicht ausgelöst --> null
        ServiceException serviceException = catchThrowableOfType(
                () -> userService.register(data),
                ServiceException.class);

        // steht in der Exception die Message "E-Mail eingeben"?
        assertThat(serviceException).hasMessage("E-Mail eingeben");
    }

    @Test
    public void wennPasswortWenigerAlsAchtZeichenDannServiceException(){
        RegistrationData  data = new RegistrationData("email@jemand.com", "asdf123", "Manfred");
        // Schreibt die ausgelöste ServiceException in eine Variable
        // falls Exception nicht ausgelöst --> null
        ServiceException serviceException = catchThrowableOfType(
                () -> userService.register(data),
                ServiceException.class);

        // steht in der Exception die Message "Passwort muss aus mindestens 8 Zeichen bestehen"?
        assertThat(serviceException).hasMessage("Passwort muss aus mindestens 8 Zeichen bestehen");
    }

    @Test
    public void wennPasswortKeineZahlEnthaeltDannServiceException(){
        RegistrationData  data = new RegistrationData("email@jemand.com", "HalloWelt", "Manfred");
        // Schreibt die ausgelöste ServiceException in eine Variable
        // falls Exception nicht ausgelöst --> null
        ServiceException serviceException = catchThrowableOfType(
                () -> userService.register(data),
                ServiceException.class);

        // steht in der Exception die Message "Passwort muss mindestens eine Zahl enthalten"?
        assertThat(serviceException).hasMessage("Passwort muss mindestens eine Zahl enthalten");
    }

    @Test
    public void wennEmailBereitsVerwendetDannServiceException(){
        // Was soll userRepository.findByEmail("email@jemand.com") zurückgeben wenn es aufgerufen wird?
        Mockito
                .doReturn(Optional.of(new User()))
                .when(userRepository).findByEmail("email@jemand.com");


        RegistrationData  data = new RegistrationData("email@jemand.com", "HalloWelt9", "Manfred");

        ServiceException serviceException = catchThrowableOfType(
                () -> userService.register(data),
                ServiceException.class);

        assertThat(serviceException).hasMessage("E-Mail Adresse bereits verwendet");
    }

    @Test
    public void speicherePasswortMitHashUndSalt(){

        String password = "HalloWelt9";
        RegistrationData  data = new RegistrationData("email@jemand.com", password, "Manfred");
        User user = userService.register(data);

        // Steht im User das gehashte Passwort?
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        assertTrue(passwordEncoder.matches(password, user.getPassword()));
    }

    @Test
    public void speichereEmailsLowercase(){
        RegistrationData data = new RegistrationData("eMail@email.COM", "HalloWelt9", "Manfred");
        User user = userService.register(data);
        assertEquals("email@email.com", user.getEmail());
    }

    @Test
    public void userDatenMuessenMitEingabeUebereinstimmen(){
        RegistrationData data = new RegistrationData("email@email.com", "HalloWelt9", "Manfred");
        User user = userService.register(data);
        assertEquals("email@email.com", user.getEmail());
        assertTrue(bCryptPasswordEncoder.matches("HalloWelt9", user.getPassword()));
        assertEquals("Manfred", user.getName());
    }

    @Test
    public void neuerUserHatNurRolleUSER(){
        RegistrationData data = new RegistrationData("email@email.com", "HalloWelt9", "Manfred");
        User user = userService.register(data);
        List<Role> roles = user.getRoles();
        assertEquals(1, roles.size());
        assertEquals("USER", roles.get(0).getName());
    }

}