import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();
    public static int randomNumber(int low, int high){
        //Random random = new Random();
        int result = random.nextInt(high - low) + low;
        return result;
    }
}
