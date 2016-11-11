package com.gabe.android.aca.snoozecamp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import static com.gabe.android.aca.snoozecamp.R.id.imageView;

/**
 * Created by Gabe on 11/3/16.
 */

public class LookbookViewHolder extends RecyclerView.ViewHolder {

    public ImageView mimageView;


    public LookbookViewHolder(View itemView)
    {
        super(itemView);
        mimageView = (ImageView) itemView.findViewById(imageView);


    }

}
