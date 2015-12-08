package com.kalapuneet.photofilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView kalapImg;
    Drawable tutorFace;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kalapImg = (ImageView) findViewById(R.id.kalapImg);

        tutorFace = getResources().getDrawable(R.drawable.bucky);
        bitmap = ((BitmapDrawable) tutorFace).getBitmap();
        Bitmap newPhoto = invertImage(bitmap);
        kalapImg.setImageBitmap(newPhoto);

        //Save the image to the users device
        MediaStore.Images.Media.insertImage(getContentResolver(),newPhoto,"title","description");

        /*
        Drawable[] layers = new Drawable[2];
        layers[0] = getResources().getDrawable(R.drawable.bucky);
        layers[1] = getResources().getDrawable(R.drawable.frame);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        kalapImg.setImageDrawable(layerDrawable);
        */



    }



    //Invert a bitmap image
    public static  Bitmap invertImage(Bitmap bitmap){

        Bitmap newPhoto = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());

        int A, R, G, B;
        int pixelColor;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();

        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                pixelColor = bitmap.getPixel(x,y);
                A = Color.alpha(pixelColor);
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);
                newPhoto.setPixel(x,y,Color.argb(A, R, G, B));
            }
        }

        return newPhoto;
    }
}
