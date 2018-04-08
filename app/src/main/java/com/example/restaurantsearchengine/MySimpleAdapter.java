package com.example.restaurantsearchengine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class MySimpleAdapter extends SimpleAdapter {

	HashMap<String, String> map = new HashMap<String, String>();
    public MySimpleAdapter(Context context, List<? extends Map<String, String>> data,
            int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        if (position % 2 == 1) {
        	view.setBackgroundColor(Color.YELLOW);
        	view.setMinimumWidth(parent.getWidth()); 
    	} else {
    		view.setBackgroundColor(Color.CYAN); 
    		view.setMinimumWidth(parent.getWidth()); 
    	}
        return view;
    }
}
