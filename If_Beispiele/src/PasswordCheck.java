public class PasswordCheck {
    private String password;
    public boolean isSecure(){
        if(!password.equals("123")
                && password.contains("$")){
            return true;
        }
        return false;
    }
}
