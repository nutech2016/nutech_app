package com.example.anandundavia.nutech16;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Euphoria extends Fragment
{

    public Euphoria()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_euphoria, container, false);
        String titles[];
        String others[];
        String locations[];
        String descriptions[];

        titles = getResources().getStringArray(R.array.euphoriatitles);
        others = getResources().getStringArray(R.array.euphoriaother);
        locations = getResources().getStringArray(R.array.euphorialoc);
        descriptions = getResources().getStringArray(R.array.euphoriadesc);
        ListView list = (ListView) rootView.findViewById(R.id.listView);
        list.setDivider(null);
        EventDetailAdapter eventDetailAdapter = new EventDetailAdapter(getContext(), titles, others, locations, descriptions);
        list.setAdapter(eventDetailAdapter);
        eventDetailAdapter.notifyDataSetChanged();

        return rootView;
    }


}
