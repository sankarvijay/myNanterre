package miage.parisnanterre.fr.mynanterre.implem;

import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.fragment.AccueilFragment;
import miage.parisnanterre.fr.mynanterre.fragment.CrousFragment;
import miage.parisnanterre.fr.mynanterre.fragment.SportFragment;
import miage.parisnanterre.fr.mynanterre.fragment.TrainFragment;

public class Accueil extends AppCompatActivity {

    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //display the logo during 5 seconds,
        timer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                FragmentManager fragmentManager;
                BottomNavigationView bottomNavigation;

                //set the new Content of your activity
                Accueil.this.setContentView(R.layout.navbar);


                bottomNavigation = findViewById(R.id.navigationView);
                fragmentManager = getSupportFragmentManager();

                bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    Fragment fragment;

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                        switch (menuItem.getItemId()) {
                            case R.id.navigation_accueil:
                                fragment = new AccueilFragment();
                                break;
                            case R.id.navigation_sports:
                                fragment = new SportFragment();
                                break;
                            case R.id.navigation_crous:
                                fragment = new CrousFragment();
                                break;
                            case R.id.navigation_train:
                                fragment = new TrainFragment();
                                break;
                            default:
                                break;
                        }
                        final FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.container, fragment).commit();
                        return true;
                    }
                });
            }
        }.start();


    }
}

