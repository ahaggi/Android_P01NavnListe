package src.liste_uten_objektorientert;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.example.haji.p01_listview.R;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by haji on 1/17/18.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<Integer> bilderIds = new ArrayList<>();

    // Constructor
    public ImageAdapter(Context c , ArrayList<String> imagesList ){
        mContext = c;

        for(String str : imagesList){
            int _id = mContext.getResources().getIdentifier( str , "drawable" , mContext.getPackageName());
            bilderIds.add(_id);
        }
    }

    @Override
    public int getCount() {
        return bilderIds.size();
    }

    @Override
    public Object getItem(int position) {
        return bilderIds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource( bilderIds.get(position) );
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        return imageView;
    }

}