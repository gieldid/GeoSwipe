package giel.hva.nl.geoswipe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class SwipeActivity extends AppCompatActivity {
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        context = getApplicationContext();
        final List<GeoObject> geoObjectList = new ArrayList<>();

        for(int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS.length; i++){
            geoObjectList.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_Answers[i]));

        }


        RecyclerView geoRecyclerView =  findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        geoRecyclerView.setLayoutManager(layoutManager);

        final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, geoObjectList);
        geoRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallBack  =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = (viewHolder.getAdapterPosition());

                        CharSequence text;
                        int duration = Toast.LENGTH_SHORT;

                        if(direction == ItemTouchHelper.LEFT && geoObjectList.get(position).isInEurope() || direction == ItemTouchHelper.RIGHT && !geoObjectList.get(position).isInEurope()){
                            text = "Correct";
                        }else{
                            text = "False";
                        }
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                        geoObjectList.remove(position);
                        mAdapter.notifyItemRemoved(position);


                    }
                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallBack);
        itemTouchHelper.attachToRecyclerView(geoRecyclerView);

    }
}
