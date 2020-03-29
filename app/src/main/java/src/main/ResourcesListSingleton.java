package src.main;


import java.lang.reflect.Field;
import java.util.ArrayList;
import com.example.haji.p01_listview.R;
import android.util.Log;

public class ResourcesListSingleton {

    static ResourcesListSingleton instance;

    // Alt you can import the R class from import com.example.haji.p01_listview.R;
    // and then use R.Drawable.class.getFields()

    Class<?> Rclass;
    ArrayList<String> bilderIds = new ArrayList<String>();

    public static ResourcesListSingleton getInstance(Class<?> _Rclass) {
        if (instance == null) {
            instance = new ResourcesListSingleton();
            instance.Rclass = _Rclass;
        }
        return instance;
    }

    public ArrayList<String> getImagesList() {
        if (bilderIds.size() == 0)
            for (Field felt : R.drawable.class.getFields())
                try {
                    if (felt.getName().matches("^b_+\\S*$"))
                        bilderIds.add(felt.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }


        for (int i = 0; i < 20; i++)
            bilderIds.add(i+"");
//            Log.i("¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  " + bilderIds.get(i));

        return bilderIds;
    }
}