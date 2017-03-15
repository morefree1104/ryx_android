package com.ryx.ryx.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ryx.ryx.R;


public class LoadingDialog extends Dialog  {
	private ImageView spaceshipImage;
	private Animation hyperspaceJumpAnimation;
	public LoadingDialog(Context context, String msg) {
		super(context, R.style.loading_dialog);

		setContentView(R.layout.loading_dialog);
		Window dialogWindow = getWindow();
		dialogWindow.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		dialogWindow.setGravity(Gravity.CENTER);
		setCanceledOnTouchOutside(false);
		setCancelable(true);
		LinearLayout layout = (LinearLayout) findViewById(R.id.dialog_view);// 加载布局
		// main.xml中的ImageView
		spaceshipImage = (ImageView) findViewById(R.id.img);
		TextView tipTextView = (TextView) findViewById(R.id.tipTextView);// 提示文字
		// 加载动画
		hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.anim.loading_animation);
		// 使用ImageView显示动画
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		tipTextView.setText(msg);// 设置加载信息

//		Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

		setCancelable(false);// 不可以用“返回键”取消
	}

	@Override
	public void show() {
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		super.show();
	}
}
