package antoinemoghaddar.app.digitalmoose.com.kwoot.Main;

import org.apache.commons.codec.binary.Hex;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.HelperClasses.Kwoot;

/**
 * @author Antoine Moghaddar (TheMoose)
 * @version 1.0.0
 */

public class KwootController {

    private List<Kwoot> kwoots;
    private static KwootController instance;

    private KwootController() {
//        requestKwoots();
    }

    private void addDummy() {
        kwoots = new ArrayList<>();
        kwoots.add(new Kwoot("Kwoot 1", "Antoine Moghaddar"));
        kwoots.add(new Kwoot("Kwoot 2", "Alpha"));
        kwoots.add(new Kwoot("Kwoot 3", "Beta"));
        kwoots.add(new Kwoot("Kwoot 4", "Theta"));

    }

    public static KwootController getInstance() {
        if (instance == null) {
            instance = new KwootController();
        }
        return instance;
    }

    public List<Kwoot> getKwoots() {
        return kwoots;
    }

    public Kwoot getSingleKwoot(int position) {
        return kwoots.get(position);
    }


    //_____________________________________________________________________________________

    public boolean login() {
        return false;
    }

    public String register(String username, String password, String gender) {
        return null;
    }

    public int upvote() {
        return -1;
    }

    public void addQuotes() {
    }

    /**
     * @param value;     password combination unXORed with the hascode (created by getPassword())
     * @param secretkey; the secret key provided by the client
     * @return returns a perfectly fine API hash which is ready to be send as a header request
     * @definition The used encoder for creating the required hash by the CCVShop API
     * @description XORes and Hashes the full API password provided by another method with SHA512
     * @--> and the provided secret key by the client
     * @use XORes the provided password combination (created in getPassword()) with the secret key
     * @--> and hashes it all into one SHA512 encoded String
     */
    public String SHA512_encoder(String value, String secretkey) {
        try {
            // Get an hmac_sha1 secretkey from the raw secretkey bytes
            byte[] keyBytes = secretkey.getBytes();
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA512");

            // Get an hmac_sha512 Mac instance and initialize with the signing secretkey
            Mac mac = Mac.getInstance("HmacSHA512");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(value.getBytes());

            // Convert raw bytes to Hex
            byte[] hexBytes = new Hex().encode(rawHmac);

            //  Covert array of Hex bytes to a String
            System.out.println(new String(hexBytes, "UTF-8"));
            return new String(hexBytes, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
