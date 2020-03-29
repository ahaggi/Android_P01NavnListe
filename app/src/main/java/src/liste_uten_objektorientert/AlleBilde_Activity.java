package src.liste_uten_objektorientert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.example.haji.p01_listview.R;

import java.util.ArrayList;

import src.main.ResourcesList;
import src.main.ResourcesListSingleton;

public class AlleBilde_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allebilde_layout);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

//        ArrayList<String> imagesList = ResourcesListSingleton.getInstance(R.drawable.class).getImagesList();
        ArrayList<String> imagesList = ResourcesList.Companion.getInstance( "test").getImagesList();

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this , imagesList));

        gridView.setOnItemClickListener((adapterView, view, pos, id)->{

            Intent intent = new Intent(AlleBilde_Activity.this, Bilde_Activity.class);
            intent.putExtra("key" , ""+ imagesList.get(pos));
            Log.i("view pos in the adapter" ,"" + id);
            Log.i("rowID" ,"" + pos);

            startActivity(intent);

        });




    }
}
