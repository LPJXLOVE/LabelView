package com.example.lpjxlove.labelview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LPJXLOVE on 2016/5/22.
 */
public  abstract class LabelViewAdapter {
    abstract int getCount();
    abstract View getView(ViewGroup viewGroup, int position);

}
