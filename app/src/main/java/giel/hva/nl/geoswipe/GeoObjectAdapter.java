package giel.hva.nl.geoswipe;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectViewHolder>  {


    private Context context;
    private List<GeoObject> listGeoObject;


    public GeoObjectAdapter(Context context, List<GeoObject> listGeoObject) {
        this.context = context;
        this.listGeoObject = listGeoObject;
    }


    @Override
    public GeoObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new GeoObjectViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final GeoObjectViewHolder holder, final int position) {
        // Gets a single item in the list from its position
        final GeoObject geoObject = listGeoObject.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list

        holder.getGeoImageView().setImageResource(geoObject.getImageName());

    }



    @Override
    public int getItemCount() {
        return listGeoObject.size();
    }
}