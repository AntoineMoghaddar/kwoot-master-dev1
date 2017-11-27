package antoinemoghaddar.app.digitalmoose.com.kwoot.Main.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.HelperClasses.CustomAdapter;
import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.HelperClasses.Kwoot;
import antoinemoghaddar.app.digitalmoose.com.kwoot.Main.KwootController;
import antoinemoghaddar.app.digitalmoose.com.kwoot.R;

public class TrendingFragment extends Fragment {

    KwootController model;
    ListView listViewMainFragment;
    private CustomAdapter theAdapter;
    private OnFragmentInteractionListener mListener;


    public TrendingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trending, container, false);
        model = KwootController.getInstance();
        List<Kwoot> kwoots = model.getKwoots();

        listViewMainFragment = view.findViewById(R.id.ListViewMainFragment);
        theAdapter = new CustomAdapter(getContext(), R.layout.row_item, kwoots);
        listViewMainFragment.
                setAdapter(
                        theAdapter);
        theAdapter.notifyDataSetChanged();

        listViewMainFragment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onItemClicked(position);
            }
        });
        return view;
    }

    public void refresh() {
        theAdapter.notifyDataSetChanged();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (OnFragmentInteractionListener) activity;

    }

    public interface OnFragmentInteractionListener {
        void onItemClicked(int position);
    }

}
