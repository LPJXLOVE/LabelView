package com.example.lpjxlove.labelview;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import static com.example.lpjxlove.labelview.R.id.tv_title;

/**
 * Created by LPJXLOVE on 2016/5/22.
 */
public class Label_ViewAdapter extends LabelViewAdapter {
    private Context context;
    private List<String> list;

    public Label_ViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    int getCount() {
        return list.size();
    }

    @Override
    View getView(ViewGroup parent, int position) {
       // View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.labelview_layout,parent);
       // TextView tv= (TextView) view.findViewById(tv_title);
         TextView tv=new TextView(context);
         tv.setBackgroundResource(R.drawable.circle_background);
         tv.setText(list.get(position));
        tv.setPadding(24,24,24,24);
        tv.setTextColor(Color.WHITE);
      //  tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
      //  tv.setGravity(Gravity.CENTER_HORIZONTAL);
        return tv;
    }

}
