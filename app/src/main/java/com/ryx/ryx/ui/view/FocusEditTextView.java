package com.ryx.ryx.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ryx.ryx.R;


/**
 * 共同的文本输入视图，包括获取焦点更改边框颜色
 */
public class FocusEditTextView extends RelativeLayout {

    private String hintStr;
    private String valueStr;
    private Drawable textDrawable;
    private RelativeLayout mainRl;
    private int editType;


    private EditText editTxt;
    public FocusEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCustomAttr(context, attrs);
        initView();
    }

    private void initCustomAttr(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.FocusEditTextView);
        // 获取自定义属性资源ID
        hintStr = a.getString(R.styleable.FocusEditTextView_hintText);
        textDrawable = a.getDrawable(R.styleable.FocusEditTextView_textDrawable);
        editType = a.getInt(R.styleable.FocusEditTextView_editType, InputType.TYPE_CLASS_TEXT);
        valueStr = a.getString(R.styleable.FocusEditTextView_value);

    }

    /**
     * 初始化布局信息
     */
    private void initView() {
        View.inflate(getContext(), R.layout.focus_edit_text_view, this);
        editTxt = (EditText) findViewById(R.id.edit_text);
        mainRl = (RelativeLayout) findViewById(R.id.main_rl);
        editTxt.setHint(hintStr);
        editTxt.setInputType(editType);
        editTxt.setText(valueStr);
//        String typeName = getResources().getResourceTypeName(textDrawable);
//        if ("mipmap".equals(typeName) || "drawable".equals(typeName)) {
//            Drawable drawable = ContextCompat.getDrawable(getContext(), textDrawable);
        if (textDrawable != null) {
            // 这一步必须要做,否则不会显示.
            textDrawable.setBounds(0, 0, textDrawable.getMinimumWidth(), textDrawable.getMinimumHeight());
            editTxt.setCompoundDrawables(textDrawable,null,null,null);
        }
        editTxt.setOnFocusChangeListener(new OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //根据edittext焦点情况，切换父元素的背景
                if(hasFocus){
                    mainRl.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_et_style));
                }else{
                    mainRl.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_et_normal));
                }
            }
        });

//        }

    }


    public String getText(){
        return editTxt.getText().toString();
    }

    public void setText(String text){
        editTxt.setText(text);
    }

    public void setHintStr(String hintTxt){
        editTxt.setHint(hintTxt);
    }


}
