package com.indapoint.databinding.demo.vector;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.applantation.android.svg.SVG;
import com.applantation.android.svg.SVGParseException;
import com.applantation.android.svg.SVGParser;

public class Binding {

    @BindingAdapter({"bind:svg"})
    public static void setDrawable(ImageView imageView, String resourceName) {
        try {

            int resID = imageView.getContext().getResources().getIdentifier(resourceName , "raw", imageView.getContext().getPackageName());

            SVG svgFlashLight = SVGParser.getSVGFromResource(imageView.getContext().getResources(), resID);
            imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            imageView.setImageDrawable(svgFlashLight.createPictureDrawable());
        } catch (SVGParseException e) {
            e.printStackTrace();
        }
    }

    @BindingAdapter({"bind:typeface"})
    public static void setTypeFace(TextView textView, String fontName) {
        textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "font/" + fontName + ".ttf"));
    }
}