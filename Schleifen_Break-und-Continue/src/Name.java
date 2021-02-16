public class Name {
    // Instanzvariable
    private String name;
    // Konstruktor
    public Name(String name){
        this.name = name; // Übergabeparameter der Instanzvariable zuweisen
    }
    public String umdrehen(){
        String result = "";
        for(int i = name.length() - 1; i >= 0; i--){
            char zeichen = name.charAt(i); //name.substring(i, i+1);
            result += zeichen;
        }
        return result;
    }

    public String getName(){
        return name;
    }
}
