package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> listHeaders;
    private HashMap<String, List<String>> listAllChild;

    public ExpandableListViewAdapter(Context context) {
        this.context = context;
        createExpandableList();
    }

    @Override
    public int getGroupCount() {
        return listHeaders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listAllChild.get(listHeaders.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listHeaders.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listAllChild.get(listHeaders.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.expandable_group_layout,parent,false);
        TextView listHeaderTV = convertView.findViewById(R.id.group_header_tv);
        ImageView arrow_iv = convertView.findViewById(R.id.arrow_iv);
        listHeaderTV.setText(listHeaders.get(groupPosition));


        Boolean check = false;

        try {
            listAllChild.get(this.listHeaders.get(groupPosition)).get(0);
        }
        catch (Exception ex)
        {
            check = true;
            ex.printStackTrace();
        }
        if(check)
        {
            arrow_iv.setVisibility(View.INVISIBLE);
        }

        if(isExpanded)
        {
            arrow_iv.setImageResource(R.drawable.up);
        }
        else
        {
            arrow_iv.setImageResource(R.drawable.down);
        }

        if (groupPosition==0){
            arrow_iv.setImageResource(R.drawable.ic_home_black_24dp);
        }



        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.expandable_child_layout,parent,false);
        TextView listChildTV = convertView.findViewById(R.id.single_list_item_tv);
        listChildTV.setText(listAllChild.get(listHeaders.get(groupPosition)).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }




    private void createExpandableList() {
        listHeaders = new ArrayList<>();
        listAllChild = new HashMap<>();

        listHeaders.add("Home");
        listHeaders.add("Category");
        listHeaders.add("Profile");

        ArrayList<String> expenditure = new ArrayList<>();
        expenditure.add("");


        ArrayList<String> moments = new ArrayList<>();
        moments.add("Take a Photo");
        moments.add("View Event Gallery");

        ArrayList<String> moreOnEvent = new ArrayList<>();
        moreOnEvent.add("Edit Event");


        listAllChild.put(listHeaders.get(0),expenditure);
        listAllChild.put(listHeaders.get(1),moments);
        listAllChild.put(listHeaders.get(2),moreOnEvent);
    }
}
