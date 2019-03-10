package miage.parisnanterre.fr.mynanterre.implem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import miage.parisnanterre.fr.mynanterre.R;


/**
 * Created by Sankar Vijay on 07/03/2019.
 */
public class ListeTrain extends AppCompatActivity {

    GridView androidGridView;

    Integer[] imageIDs = {
            R.drawable.rera, R.drawable.lignel
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_train);

        androidGridView = (GridView) findViewById(R.id.gridView);
        androidGridView.setAdapter(new TrainGridAdapter(this));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                CallFunc(position);


            }
        });

    }

    private void CallFunc(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(getApplicationContext(), TrainRerA.class);
                break;
            case 1:
                intent = new Intent(getApplicationContext(), TrainLigneL.class);
                break;
        }
// pour éviter le if tu peux faire un return sur default du switch
        if (intent != null) {
            startActivity(intent);
        }
    }

    public class TrainGridAdapter extends BaseAdapter {
        private Context mContext;

        public TrainGridAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(400, 400));
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageIDs[position]);
            return mImageView;
        }
    }
}