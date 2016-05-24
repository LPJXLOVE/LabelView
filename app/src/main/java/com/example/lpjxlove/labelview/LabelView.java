package com.example.lpjxlove.labelview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LPJXLOVE on 2016/5/22.
 */
public class LabelView extends ViewGroup {
    private Context context;
    private LabelViewAdapter adapter;//适配器
    private int gap;//view之间的间隙


    public LabelView(Context context) {
        this(context, null);
    }

    public LabelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.LabelView,defStyleAttr,R.style.Default_LabelView);
        int count=a.getIndexCount();
        for (int i= 0;i<count; i++){
            switch (i){

                case R.styleable.LabelView_gap:

                    gap= (int) a.getDimension(R.styleable.LabelView_gap,20);

                    break;
            }

        }

        a.recycle();

    }

    public LabelViewAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(LabelViewAdapter adapter) {
        this.adapter = adapter;
        InitData();
    }

    /**
     * 初始化数据
     */
    private void InitData() {
        if (adapter == null) {
            return;
        }
       int count = adapter.getCount();
        removeAllViews();
        for (int i = 0; i < count; i++) {
            View v = adapter.getView(this, i);
            addView(v, generateDefaultLayoutParams());
        }


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heigh = 500;
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(widthSize, heigh);


      /*  for (int i = 0; i < count; i++) {
            View v = getChildAt(i);
            v.getMeasuredHeight();
        }*/
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }





   /* @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }*/

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (adapter==null){
            return;
        }

        int top;
        int left;
        int right=0;
        int plus_right=0;//累加right的长度
        int bottom;
        int rows=1;//行数
        int width=getWidth();//屏幕的宽度


        int c = getChildCount();
        for (int i = 0; i < c; i++) {
            View v = getChildAt(i);
            int h= v.getMeasuredHeight();//view的高度
            int w= v.getMeasuredWidth();//view的宽度

            //提前获取后一个view的宽度以便后面的换行操作
            int f_w=0;
            if ( i < c-1 ){
                View view=getChildAt(i+1);
                f_w=view.getMeasuredWidth();
            }

            //当后一个view的宽度加上当前的right宽度大于屏幕的宽度就换行
            int f_width=right+f_w;
            if (f_width > width){
                rows++;
                plus_right=0;
            }



            top=(rows-1)*(h+gap);
            left=plus_right+gap;
            right=left+w;
            bottom=top+h;
            plus_right=right;


            v.layout(left, top, right, bottom);

           /* Log.i("test","h"+h);
            Log.i("test","w"+w);
            Log.i("test","right"+right);
            Log.i("test","bottom"+bottom);
            Log.i("test","left"+left);
            Log.i("test","top"+top);
            Log.i("test","width"+getWidth());*/
        }


    }
}
