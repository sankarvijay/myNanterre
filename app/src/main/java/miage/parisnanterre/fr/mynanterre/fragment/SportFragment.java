package miage.parisnanterre.fr.mynanterre.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.implem.ListeSport;

/**
 * Created by Sankar Vijay on 26/01/2019.
 */
public class SportFragment extends ListFragment implements AdapterView.OnItemClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.liste_cat_sport, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       /* try {
            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT categorie FROM categorie_sport;";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            while (rst.next()) {
                String categorie = rst.getString("categorie");
                sports.add(categorie);

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, sports);
            //ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.CatSport, android.R.layout.simple_list_item_1) ;
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.CatSport, android.R.layout.simple_list_item_1) ;
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Create intent
        Intent intent = new Intent(view.getContext(), ListeSport.class);
        //Start details activity
        startActivity(intent);
    }
}
