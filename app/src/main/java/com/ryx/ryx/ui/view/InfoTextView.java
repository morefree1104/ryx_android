package com.ryx.ryx.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ryx.ryx.R;


/**
 * 个人信息页输入框视图
 */
public class InfoTextView extends RelativeLayout {

    private String hintStr;
    private TextView titleTv;
    private int editType;
    private String titleStr;
    private String valueStr;

    private TextView editTxt;
    public InfoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCustomAttr(context, attrs);
        initView();
    }

    private void initCustomAttr(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.FocusEditTextView);
        // 获取自定义属性资源ID
        hintStr = a.getString(R.styleable.FocusEditTextView_hintText);
        titleStr = a.getString(R.styleable.FocusEditTextView_titleText);
        editType = a.getInt(R.styleable.FocusEditTextView_editType, InputType.TYPE_TEXT_VARIATION_NORMAL);
        valueStr = a.getString(R.styleable.FocusEditTextView_value);

    }

    /**
     * 初始化布局信息
     */
    private void initView() {
        View.inflate(getContext(), R.layout.info_text_view, this);
        editTxt = (TextView) findViewById(R.id.content);
        titleTv = (TextView) findViewById(R.id.head_txt);
        editTxt.setHint(hintStr);
        editTxt.setInputType(editType);
        editTxt.setText(valueStr);
        titleTv.setText(titleStr);

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
