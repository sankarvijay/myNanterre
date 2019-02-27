package miage.parisnanterre.fr.mynanterre.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.implem.TrainLigneL;
import miage.parisnanterre.fr.mynanterre.implem.TrainRerA;


/**
 * Created by Sankar Vijay on 09/02/2019.
 */
public class TrainFragment extends ListFragment implements AdapterView.OnItemClickListener {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liste_train, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Trains, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CallFunc(position);
    }

    private void CallFunc(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(getView().getContext(), TrainRerA.class);
                break;
            case 1:
                intent = new Intent(getView().getContext(), TrainLigneL.class);
                break;
        }
// pour éviter le if tu peux faire un return sur default du switch
        if (intent != null) {
            startActivity(intent);
        }
    }


}
