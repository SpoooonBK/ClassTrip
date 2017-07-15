package net.estebanrodriguez.apps.classtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import net.estebanrodriguez.apps.classtrip.utilities.GoogleApiClientHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;



public class MainActivity extends AppCompatActivity {


    private static final int PLACE_PICKER_REQUEST = 1;
//    @BindView(R.id.address)TextView address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());
        ButterKnife.bind(this);

        GoogleApiClientHelper helper = new GoogleApiClientHelper(this);
        GoogleApiClient googleApiClient = helper.getGoogleApiClient();
        googleApiClient.connect();

    }

//    @OnClick(R.id.mapButton)
//    public void getPlacePicker(){
//        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//        try {
//            Timber.v("Clicked");
//            Intent intent = builder.build(this);
//            startActivityForResult(intent, PLACE_PICKER_REQUEST);
//        } catch (GooglePlayServicesRepairableException e) {
//            e.printStackTrace();
//        } catch (GooglePlayServicesNotAvailableException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == PLACE_PICKER_REQUEST && resultCode == RESULT_OK){
//            Place place = PlacePicker.getPlace(this, data);
//            address.setText(place.getAddress());
//        }
//    }
}
