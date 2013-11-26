package vit.riviera;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aboutus extends Activity
{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        
        Button b1=(Button)findViewById(R.id.button_fb);
        
        
       /* b1.setOnClickListener(new View.OnClickListener() {
     	   public void onClick(View v)
     			{
     		
     		  goToUrl ( "http://www.facebook.com/pages/Android-Developers-Group-ADG/360503390714503");
     		   }
     		});*/
        
	}
	
	
	public void goToSo (View view) {
        goToUrl ( "http://www.facebook.com/pages/Android-Developers-Group-ADG/360503390714503");
    }

   

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
