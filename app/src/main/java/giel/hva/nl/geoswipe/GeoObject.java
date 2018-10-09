package giel.hva.nl.geoswipe;

import android.view.View;

public class GeoObject {
    private int imageName;
    private boolean isInEurope;

    public GeoObject(int imageName, boolean isInEurope){
        this.imageName = imageName;
        this.isInEurope = isInEurope;
    }

    public boolean isInEurope() {
        return isInEurope;
    }

    public void setisInEurope(boolean isInEurope) {
        this.isInEurope = isInEurope;
    }


    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS =  {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand,
    };

    public static final boolean[] PRE_DEFINED_GEO_OBJECT_Answers =  {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };
}
