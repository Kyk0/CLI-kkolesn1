
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


public class Main {
    public static void main(String[] args) throws Exception {
        String command;


        if (args.length < 1) {
            printHelp();
            return;
        }

        command = args[0];

        switch (command) {
            case "hash" -> {
                String input = getArg(args, "--text");
                if (input == null) {
                    printHelp();
                    return;
                }

                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
                System.out.println(bytesToHex(encodedHash));
                // https://www.baeldung.com/sha-256-hashing-java
            }

            case "reverse" -> {
                String input = getArg(args, "--text");
                if (input == null) {
                    printHelp();
                    return;
                }

                String rvrs = new StringBuilder(input).reverse().toString();
                System.out.println(rvrs);

            }
            case "count" -> {
                String input = getArg(args, "--text");
                if (input == null) {
                    printHelp();
                    return;
                }

                System.out.println("Characters: " + input.length());

                if (hasFlag(args, "--words")) {
                    String[] words = input.trim().split("\\s+");
                    System.out.println("Words: " + words.length);
                }

            }
            default -> printHelp();
        }
    }

    static String getArg(String[] args, String key) {
        for (int i = 0; i < args.length - 1; i++) {

            if (args[i].equals(key)) {
                return args[i + 1];
            }
        }
        return null;
    }

    static boolean hasFlag(String[] args, String flag) {
        for (String a : args){
            if (a.equals(flag)){

                return true;
            }
        }
        return false;
    }

    static void printHelp() {
        System.out.println("Usage:");
        System.out.println("  java Main hash --text <text>");
        System.out.println("  java Main reverse --text <text>");
        System.out.println("  java Main count --text <text> [--words]");
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
