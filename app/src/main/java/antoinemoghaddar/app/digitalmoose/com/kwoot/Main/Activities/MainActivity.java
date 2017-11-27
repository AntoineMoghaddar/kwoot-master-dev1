package antoinemoghaddar.app.digitalmoose.com.kwoot.Main.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.Fragments.DetailFragment;
import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.Fragments.TrendingFragment;
import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.KwootController;
import antoinemoghaddar.app.digitalmoose.com.kwoot.R;

@SuppressWarnings("all")
public class MainActivity extends AppCompatActivity implements TrendingFragment.OnFragmentInteractionListener {


    private DatabaseReference mRootRef, mUserRef, mKwootRef;

    private void firebaseInit() {
        mRootRef = FirebaseDatabase.getInstance().getReference();
        mUserRef = mRootRef.child("User");
        mKwootRef = mRootRef.child("Quote");
    }

    private TrendingFragment trendingFragment;

    boolean isLandscape;
    private TextView mTextMessage;
    private KwootController controller;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Trending:
                    return true;
                case R.id.navigation_Search:
                    return true;
                case R.id.navigation_Add:
                    return true;
                case R.id.navigation_notifications:
                    return true;
                case R.id.navigation_profile:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        trendingFragment = (TrendingFragment) getSupportFragmentManager().findFragmentById(R.id.ListViewMainFragment);
//        isLandscape = (findViewById(R.id.framelayout1Landscape) != null);
//        if (isLandscape) {
//            findViewById(R.id.framelayout1Landscape).setVisibility(View.INVISIBLE);
//        }
    }

    @Override
    public void onItemClicked(int position) {
//        if (!isLandscape) {
//            Intent i = new Intent(MainActivity.this, DetailActivity.class);
//            i.putExtra("position", position);
//            startActivityForResult(i, REQUEST_CODE_EDIT);
//        } else {
//            findViewById(R.id.framelayout1Landscape).setVisibility(View.VISIBLE);
//            DetailFragment dtf = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2Landscape);
//        }
    }
}
