package antoinemoghaddar.app.digitalmoose.com.kwoot.Main.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.HelperClasses.Kwoot;
import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.KwootController;
import antoinemoghaddar.app.digitalmoose.com.kwoot.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ImageView imageDetail;
    private TextView usernameDetail, quoteDetail, timeDetail;
    private Kwoot kwoot;
    KwootController model = KwootController.getInstance();

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        quoteDetail = (TextView) view.findViewById(R.id.quotedetail);
        imageDetail = (ImageView) view.findViewById(R.id.userimagedetail);
        timeDetail = (TextView) view.findViewById(R.id.timedetail);
        usernameDetail = (TextView) view.findViewById(R.id.usernamedetail);

        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (OnFragmentInteractionListener) activity;

    }

    public interface OnFragmentInteractionListener {
//        public void onSaveButtonClicked();
    }


}
