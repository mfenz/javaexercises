public class FotoFabrik {
    public static void main(String[] args) {
        FotoFabrik testen = new FotoFabrik();
        testen.testen();
    }

    private void testen(){
        Objektiv obj1 = new Objektiv("Nikon", 16, 35);
        Objektiv obj2 = new Objektiv("Sony", 100, 400);
        Objektiv obj3 = new Objektiv("Tamron", 70, 100);
        //obj2.printObjektivInfo();

        Kamera cam1 = new Kamera("Nikon", "D80", obj1);
        cam1.printKameraInfo();

        cam1.setObjektiv(obj3);
        cam1.printKameraInfo();

    }
}
