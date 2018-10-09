package giel.hva.nl.geoswipe;

import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class GeoObjectViewHolder extends RecyclerView.ViewHolder {



    private TextView geoName;
    private ImageView imageView;
    private View view;

    public GeoObjectViewHolder(View itemView) {
        super(itemView);
        imageView =  itemView.findViewById(R.id.imageView);
        view = itemView;
    }

    public TextView getGeoName() {
        return geoName;
    }

    public void setGeoName(TextView geoName) {
        this.geoName = geoName;
    }

    public ImageView getGeoImageView() {
        return imageView;
    }

    public void setGeoImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}

