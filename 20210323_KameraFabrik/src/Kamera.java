public class Kamera extends Thread{
    private String seriennummer;
    private String farbe;

    public Kamera(String sn){
        this.seriennummer = sn;
    }

    public Kamera(){

    }

    public Kamera(String sn, String farbe){
        this.seriennummer = sn;
        this.farbe = farbe;
    }

    public void fotoMachen(){
        System.out.printf("sn=%s farbe=%s FOTO! \n", seriennummer, farbe);
//        System.out.println("FOTO!!");
    }

    @Override
    public void run() {
        while (true){
            fotoMachen();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
