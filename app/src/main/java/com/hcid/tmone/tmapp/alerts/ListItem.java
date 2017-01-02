package com.hcid.tmone.tmapp.alerts;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aaa29022 on 2017/1/2.
 */
public class ListItem {
    ImageView list_image;
    TextView list_title, list_time;
     public ListItem(ImageView list_image, TextView list_title, TextView list_time) {
         this.list_image = list_image;
         this.list_title = list_title;
         this.list_time = list_time;
     }
}
