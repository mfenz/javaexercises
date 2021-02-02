public class Geldschein {
    public boolean checkSeriennummer(int seriennummer){
        // Seriennummer darf nicht 0 oder negativ sein
        if(seriennummer == 0 || seriennummer < 0){
            return false;
        }
        // % --> Modulo Operator
        // 6 / 4 = 1
        // 6 % 4 = 2   % --> Modulo ist der Rest der Division
        if(seriennummer % 4 == 0 && seriennummer % 100 != 0){
            return true;
        }
        if(seriennummer % 100 == 0 && seriennummer % 400 != 0){
            return false;
        }
        if(seriennummer % 400 == 0){
            return true;
        }
        return false;
    }
}
