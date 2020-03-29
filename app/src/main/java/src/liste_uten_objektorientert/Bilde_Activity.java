package src.liste_uten_objektorientert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haji.p01_listview.R;

public class Bilde_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bildemednavn_layout);
        String navn = getIntent().getStringExtra("key");

        TextView txt = findViewById(R.id.textView);
        ImageView img = findViewById(R.id.imageView);

        txt.setText(navn);
        img.setImageResource(getResources().getIdentifier(navn,"drawable", getPackageName()));




    }
}