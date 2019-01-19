package miage.parisnanterre.fr.mynanterre;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Accueil extends AppCompatActivity {
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navbar);
        BottomNavigationView bottomNavigation;

        bottomNavigation = findViewById(R.id.navigationView);
        fragmentManager = getSupportFragmentManager();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_accueil:
                        fragment = new AccueilFragment();
                        break;
                    case R.id.navigation_cours:
                        fragment = new CoursFragment();
                        break;
                    case R.id.navigation_jobs:
                        fragment = new JobsFragment();
                        break;
                    case R.id.navigation_event:
                        fragment = new EventFragment();
                        break;
                    case R.id.navigation_bonsplans:
                        fragment = new BonsPlansFragment();
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
}

