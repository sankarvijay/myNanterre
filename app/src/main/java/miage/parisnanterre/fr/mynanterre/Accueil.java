package miage.parisnanterre.fr.mynanterre;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Accueil extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        BottomNavigationView bottomNavigation = findViewById(R.id.navigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.navigation_cours:
                        break;
                    case R.id.navigation_jobs:
                        Intent intent = new Intent(getApplication(), ListeOffre.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_event:
                        break;
                    case R.id.navigation_bonsplans:
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
}

