package iesnervion.rmanzano.coincatchdef;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class AdmobAdd extends AppCompatActivity {
    private InterstitialAd interstitialAd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admob_ads);
        MobileAds.initialize(this, "ca-app-pub-7562069808460151~9820427117");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(""+ R.string.interstitial_ad_unit_id);
        AdRequest request = new AdRequest.Builder().build();
        interstitialAd.loadAd(request);
        interstitialAd.setAdListener(new AdListener(){
            public void onAdLoaded(){
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }
            }

            @Override
            public void onAdClosed() {
                Intent intent = new Intent(AdmobAdd.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
