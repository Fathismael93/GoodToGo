package com.benew.client.goodtogo.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.benew.client.goodtogo.Utils.App;

public class CanaroTextView extends androidx.appcompat.widget.AppCompatTextView {
    public CanaroTextView(Context context) {
        this(context, null);
    }

    public CanaroTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanaroTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(App.canaroExtraBold);
    }

}
