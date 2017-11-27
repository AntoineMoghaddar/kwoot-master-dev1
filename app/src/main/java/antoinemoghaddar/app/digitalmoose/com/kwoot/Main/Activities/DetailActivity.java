package antoinemoghaddar.app.digitalmoose.com.kwoot.Main.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.Fragments.DetailFragment;
import antoinemoghaddar.app.digitalmoose.com.kwoot.R;

public class DetailActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

}
