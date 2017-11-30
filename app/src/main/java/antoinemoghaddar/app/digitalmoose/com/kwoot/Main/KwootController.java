package antoinemoghaddar.app.digitalmoose.com.kwoot.Main;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    private static final String TAG = "KwootController";
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    private List<Kwoot> kwoots;
    private static KwootController instance;


    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mRef;
    private String userID;


    private KwootController() {
        kwoots = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        System.out.println("___________" + userID   );

        mAuth.addAuthStateListener(mAuthListener);



        addDummy();
        retrieveKwoots();
    }

    public static KwootController getInstance() {
        if (instance == null) {
            instance = new KwootController();
        }
        return instance;
    }

    private void addDummy() {
        for (int i = 0; i < 10; i++) {
            addkwoot(i);
        }
    }

    public List<Kwoot> getKwoots() {
        return kwoots;
    }

    public Kwoot getSingleKwoot(int position) {
        return kwoots.get(position);
    }

    public void printList() {
        for (Kwoot k : kwoots) {
            System.out.println(k.toString());
        }
    }

    public void Showdata(DataSnapshot dataSnapshot) {

        System.out.println("__________<<DEBUG>> uit for voor LOG");

        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Kwoot kwoot = new Kwoot();
            kwoot.setText(ds.child(userID).getValue(Kwoot.class).getText());
            kwoot.setAuthor(ds.child(userID).getValue(Kwoot.class).getAuthor());
            kwoot.setLocation(ds.child(userID).getValue(Kwoot.class).getLocation());
            kwoot.setDate(ds.child(userID).getValue(Kwoot.class).getDate());
            Kwoot.setLikes(ds.child(userID).getValue(Kwoot.class).getLikes());

            System.out.println("__________<<DEBUG>> in for voor LOG");

            //display all the information
            Log.d(TAG, "showData: text: " + kwoot.getText());
            Log.d(TAG, "showData: author: " + kwoot.getAuthor());
            System.out.println("__________<<DEBUG>> in for na LOG");

            kwoots.add(kwoot);
        }
    }


    public void retrieveKwoots() {
        db.child("quotes").child(userID);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Showdata(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());

            }
        });
//        System.out.println("__________<<DEBUG>>");
//        db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                System.out.println("__________<<DEBUG>> in onDataChange" );
//
//                Showdata(dataSnapshot);
////
////                for(DataSnapshot childSnapSot : dataSnapshot.getChildren()) {
////                    Kwoot kwoot = childSnapSot.getValue(Kwoot.class);
////                    System.out.println("_____" + kwoot);
////                    kwoots.add(kwoot);
////                }
////                System.out.println("_____List is being printed_____");
////
////                printList();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });
    }


//    private void processReceive(Map<String, Object> kwoot) {
//        for (Map.Entry<String, Object> entry : kwoot.entrySet()) {
//            Map singleKwoot = (Map) entry.getValue();
//            System.out.println("_______" + (Kwoot) singleKwoot.get("0AntoineMoghaddar"));
//        }
//    }

    public void addkwoot(int i) {
        Kwoot kwoot = new Kwoot();
        kwoot.setText("Ola " + i);
        kwoot.setAuthor("Antoine");
        db.child("quotes").child(userID).push().setValue(kwoot);
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
