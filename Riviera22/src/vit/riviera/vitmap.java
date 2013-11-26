package vit.riviera;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
public class vitmap extends Activity {

    private MapView         mMapView;
    private MapController   mMapController;
   double lat=12.97018513083458;
   double lng=79.15630638599396;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.vitmap);
            
            
         if(haveNetworkConnection()==false) 
      {
    	  Toast.makeText(this, "Internet is required only for the first time", Toast.LENGTH_LONG).show();
    	  Log.d("rahul","internet");
      }
        mMapView = (MapView) findViewById(R.id.mapview);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        mMapView.setBuiltInZoomControls(true);
        mMapController = mMapView.getController();
        mMapController.setZoom(16);
        GeoPoint gPt = new GeoPoint((int)(lat*1E6),(int)(lng*1E6));
        //Centre map near to Hyde Park Corner, London
        mMapController.setCenter(gPt);

    }
    
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
    
    
    
    
}