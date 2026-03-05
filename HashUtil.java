import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static int hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(key.getBytes());

            int hash = 0;
            for (int i = 0; i < 4; i++) {
                hash = (hash << 8) + (digest[i] & 0xFF);
            }

            return Math.abs(hash);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
