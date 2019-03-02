package miage.parisnanterre.fr.mynanterre.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.implem.Accueil;
import miage.parisnanterre.fr.mynanterre.implem.Cgu;
import miage.parisnanterre.fr.mynanterre.implem.ListeCrous;
import miage.parisnanterre.fr.mynanterre.implem.ListeSport;
import miage.parisnanterre.fr.mynanterre.implem.TrainLigneL;
import miage.parisnanterre.fr.mynanterre.implem.TrainRerA;

/**
 * Created by Sankar Vijay on 18/01/2019.
 */
public class AccueilFragment extends Fragment {
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.photo3, R.drawable.photo1, R.drawable.photo2, R.drawable.photo4};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.accueil, container, false);

        Button mButton = (Button) v.findViewById(R.id.cgu);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent
                Intent intent = new Intent(v.getContext(), Cgu.class);
                //Start details activity
                startActivity(intent);
            }
        });
        return v;

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        carouselView = getView().findViewById(R.id.carouselView);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(sampleImages.length);
    }


}
