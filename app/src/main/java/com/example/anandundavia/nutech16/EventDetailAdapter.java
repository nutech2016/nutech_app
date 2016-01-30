package com.example.anandundavia.nutech16;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventDetailAdapter extends ArrayAdapter<String>
{

    Context localContext;
    String titles[];
    String others[];
    String locations[];
    String descriptions[];

    public EventDetailAdapter(Context context, String t[], String r[], String l[], String des[])
    {
        super(context,android.R.layout.simple_list_item_1,t);
        localContext = context;
        titles = t;
        others = r;
        locations = l;
        descriptions = des;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View localView = convertView;
        if (localView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) localContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localView = layoutInflater.inflate(R.layout.event, null);
        }
        ((TextView) localView.findViewById(R.id.eventTitle)).setText(titles[position]);
        ((TextView) localView.findViewById(R.id.loc)).setText(locations[position]);
        ((TextView) localView.findViewById(R.id.eventOther)).setText(others[position]);
        ((TextView) localView.findViewById(R.id.eventDesc)).setText(descriptions[position]);
        return localView;
    }
}
