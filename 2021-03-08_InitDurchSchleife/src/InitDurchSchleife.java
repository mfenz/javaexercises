public class InitDurchSchleife {
    public static void main(String[] args) {
        int startInt = 3;
        int array[] = new int[8];

        for(int i = 0; i < array.length; i++){
            int potenz = (int)Math.pow(startInt, i+1);
            array[i] = potenz;

            System.out.print(array[i]);
            System.out.print(" (");

            for(int j = 0; j < i+1; j++){
                System.out.print(startInt);
                if(j != i){
                    System.out.print(" * ");
                }
            }

            System.out.print(")");
            System.out.println();
        }
    }
}
