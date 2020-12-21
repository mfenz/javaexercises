import bl.FischenBl;
import ui.FischenUi;

public class Fischen {
    public static void main(String[] args) {
        FischenBl bl = new FischenBl(5, 5);
        FischenUi ui = new FischenUi(bl);
        ui.play();
    }
}
