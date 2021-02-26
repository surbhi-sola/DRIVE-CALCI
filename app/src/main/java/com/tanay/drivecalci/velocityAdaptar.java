package com.tanay.drivecalci;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class velocityAdaptar extends ArrayAdapter<velocity_time_class> {
    public velocityAdaptar(InputActivity context, ArrayList<velocity_time_class> velocityArrayList){
        super((Context) context,0,velocityArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false
            );
        }

        velocity_time_class current = getItem(position);

        TextView time= (TextView) listItemView.findViewById(R.id.time_set);
        TextView velocity= (TextView) listItemView.findViewById(R.id.velocity_set);

        time.setText(current.getTime());
        velocity.setText(current.getVelocity());

        return listItemView;

    }
}
