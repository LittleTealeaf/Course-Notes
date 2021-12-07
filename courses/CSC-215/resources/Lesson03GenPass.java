import java.util.Random;

public class Lesson03GenPass {
    public static Random rand = new Random();
    public static void main(String[] args) {
        try {
            int size = 100;
            if (args.length > 0) 
                size = Integer.parseInt(args[0]);
            String result = generatePasswordA(size);
            if (size < 1000) System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Usage: java GenPass ###");
        }
    }

    // Generate a random set of letters A-Z of given size
    public static String generatePasswordA(int size) {
        String result = "";  // The result
        for (int i = 0; i < size; i++)
            result += (char) ('A' + rand.nextInt(26));
        return result;
    }

    // Generate a random set of letters A-Z of given size
    public static String generatePasswordB(int size) {
        char[] result = new char[size];
        for (int i = 0; i < size; i++)
            result[i] = (char) ('A' + rand.nextInt(26));
        return new String(result);
    }

    // Generate a random set of letters A-Z of given size
    // Might get stack overflow: Try using java -Xss100m GenPass ... (sets stack size)
    public static String generatePasswordC(int size) {
        if (size <= 0) return "";  // Empty string
        else return (char) ('A' + rand.nextInt(26)) + generatePasswordC(size-1);
    }
}