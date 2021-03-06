/**
 *
 * Copyright (c) 2014 CoderKiss
 *
 * CoderKiss[AT]gmail.com
 *
 */

package me.dawson.noom.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NoomButton extends Button {
	public static final String TAG = "NoomButton";

	private NoomBitmap background;

	public NoomButton(Context context) {
		super(context);
	}

	public NoomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public NoomButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@SuppressWarnings("deprecation")
	public void setBackground(NoomBitmap nb) {
		if (nb == null) {
			return;
		}

		nb.retain();
		if (background != null) {
			background.release();
		}

		background = nb;
		BitmapDrawable bd = new BitmapDrawable(nb.getBitmap());
		super.setBackgroundDrawable(bd);
	}

	// view's or its ancestor's visibility changed
	@Override
	public void onVisibilityChanged(View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);
	}

	// in absolute list view , item reused
	@Override
	public void onFinishTemporaryDetach() {
		super.onFinishTemporaryDetach();
		Log.d(TAG, "onFinishTemporaryDetach");
	}

	// view attach to window, will show on screen
	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		Log.d(TAG, "onAttachedToWindow");
	}

	// in absolute list view, item recycled
	@Override
	public void onStartTemporaryDetach() {
		super.onStartTemporaryDetach();
		Log.d(TAG, "onStartTemporaryDetach");
		releaseBitmap();
	}

	// view detached from window, will destroy later
	@Override
	public void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		Log.d(TAG, "onDetachedFromWindow");
		releaseBitmap();
	}

	@SuppressWarnings("deprecation")
	private void releaseBitmap() {
		if (background != null) {
			background.release();
			background = null;
		}

		super.setBackgroundDrawable(null);
	}
}
