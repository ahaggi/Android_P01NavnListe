package src.liste_uten_objektorientert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haji.p01_listview.R;

import java.util.ArrayList;

import src.main.ResourcesListSingleton;

public class ListeMedNavn_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Array of strings...

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listemednavn_layout);


        ArrayList<String> imagesList = ResourcesListSingleton.getInstance(R.drawable.class).getImagesList();



        cusAdp adapter = new cusAdp(imagesList);
        /** eller kan vi definere vårt eget list_item som innholder kun en "textView"
         * og kalle den med (R.layout.list_item) UTEN ANDROID
         *  Se android.R.layout.simple_list_item_1*/

        ListView listView = findViewById(R.id.listView_ListeMedNavn_Act);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                (AdapterView<?> adapterView, View view, int i, long l) -> {
                    if (l < 5) {
                        Intent intent = new Intent(ListeMedNavn_Activity.this, Bilde_Activity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); will cause that Bilde_Activity becomes the root on an empty history stack
                        intent.putExtra("key", "" + imagesList.get(i));
                        startActivity(intent);

                    }
                    Toast.makeText(getApplicationContext(), "You clicked on position : " + i + " and id : " + l, Toast.LENGTH_SHORT).show();
                });
    }

    public class cusAdp extends BaseAdapter {
        ArrayList<String> imagesList;

        public cusAdp(ArrayList<String> imagesList) {

            this.imagesList = imagesList;
        }

        @Override
        public CharSequence[] getAutofillOptions() {
            return super.getAutofillOptions();
        }

        public int getCount() {
            return imagesList.size();
        }

        @Override
        public Object getItem(int i) {
            return imagesList.get(i);
        }

        @Override
        public long getItemId(int i) {
            String item = imagesList.get(i);
            return imagesList.indexOf(item); // = i
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

//            final Context context = viewGroup.getContext();
//            if(view == null) {
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                view = inflater.inflate(R.layout.item_power_menu, viewGroup, false);
//            }

            if(view == null){
                // LayoutInflater class is used to instantiate layout XML file into its corresponding View objects.
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(R.layout.myTextItemView, null);
            }

            TextView rawTextView1 = (TextView) view.findViewById(R.id.textView1);
            rawTextView1.setText(imagesList.get(i));

            return view;
        }
    }
}