package net.estebanrodriguez.apps.classtrip.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.google.android.gms.common.api.GoogleApiClient;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.utilities.GoogleApiClientHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;



public class MainActivity extends AppCompatActivity {


//    @BindView(R.id.address)TextView address;
    @BindView(R.id.fragment_holder) FrameLayout mFragmentHolder;
    @BindView(R.id.toolbar_main) Toolbar mMainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());
        ButterKnife.bind(this);

        setSupportActionBar(mMainToolbar);

        GoogleApiClientHelper helper = new GoogleApiClientHelper(this);
        GoogleApiClient googleApiClient = helper.getGoogleApiClient();
        googleApiClient.connect();

    }


}
