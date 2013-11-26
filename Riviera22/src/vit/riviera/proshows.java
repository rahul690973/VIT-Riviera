package vit.riviera;


import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ViewSwitcher.ViewFactory;

public class proshows extends Activity implements ViewFactory {

	Integer pics[] = {R.drawable.sukh, R.drawable.loy, R.drawable.chery, R.drawable.ryan};
	
	Integer pics1[] = {R.drawable.sukh_det, R.drawable.loy_det, R.drawable.cher_det, R.drawable.ryan_det};
	
	
	
	

	ImageSwitcher iSwitcher;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.proshows);

		iSwitcher = (ImageSwitcher) findViewById(R.id.ImageSwitcher01);
		iSwitcher.setFactory(this);
		iSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		iSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));

		Gallery gallery = (Gallery) findViewById(R.id.Gallery01);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				iSwitcher.setImageResource(pics1[arg2]);
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {

		private Context ctx;

		public ImageAdapter(Context c) {
			ctx = c; 
		}

		@Override
		public int getCount() {

			return pics.length;
		}

		@Override
		public Object getItem(int arg0) {

			return arg0;
		}

		@Override
		public long getItemId(int arg0) {

			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {

			ImageView iView = new ImageView(ctx);
			iView.setImageResource(pics[arg0]);
			iView.setScaleType(ImageView.ScaleType.FIT_XY);
			iView.setLayoutParams(new Gallery.LayoutParams(250, 250));
			return iView;
		}

	}

	@Override
	public View makeView() {
		ImageView iView = new ImageView(this);
	//	iView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		iView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		iView.setLayoutParams(new 
				ImageSwitcher.LayoutParams(
					LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		//ImageSwitcher.LayoutParams(150,150));
		iView.setBackgroundColor(0xFF000000);
		return iView;
	}
}