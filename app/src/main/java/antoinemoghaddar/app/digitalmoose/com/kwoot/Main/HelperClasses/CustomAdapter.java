package antoinemoghaddar.app.digitalmoose.com.kwoot.Main.HelperClasses;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import antoinemoghaddar.app.digitalmoose.com.kwoot.R;

/**
 * Created by gebruiker on 17/11/2017.
 */

public class CustomAdapter extends ArrayAdapter<Kwoot> {

    private TextView quote, username, time;
    private ImageView userImage;

    public CustomAdapter(Context context, int resource, List<Kwoot> objects) {
        super(context, resource, objects);
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            view = vi.inflate(R.layout.row_item, null);
        }

        Kwoot kwoot = getItem(position);

        if (kwoot != null) {
            quote = (TextView) view.findViewById(R.id.quoterow);
            username = (TextView) view.findViewById(R.id.username);
            userImage = (ImageView) view.findViewById(R.id.userimage);
            time = (TextView) view.findViewById(R.id.time);

            quote.setText(kwoot.getText());
            username.setText(kwoot.getAuthor());
            time.setText(kwoot.getDate());
//            userImage.setImageResource(/*TODO retrieve image from firebase*/);
        }

        return view;
    }
}
