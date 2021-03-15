public class MethodenUeberladen {
    public static void main(String[] args) {
        MethodenUeberladen mu = new MethodenUeberladen();
        mu.testen();
    }

    private void testen(){
        float a = 5.5f;
        int b = 10;
        print(a);
        print(b);
        print(15.0f);
    }

    private void print(float z){
        System.out.printf("Float %f \n", z);
    }

    private void print(int z){
        System.out.printf("Int %d \n", z);
    }
}
