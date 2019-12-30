package com.arvind.ooug.taskgci.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class ImageResult implements Serializable {
    private String fullurl;
    private String thumburl;
    private String title;

    public String getFullurl() {
        return fullurl;
    }
    public String getThumbUrl() {
        return thumburl;
    }
    public String getTitle() {
        return title;
    }


    public ImageResult(JSONObject json){
        try {
            this.fullurl = json.getString("link");
            this.title =json.getString("title");
            this.thumburl = json.getJSONObject("image").getString("thumbnailLink");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<ImageResult> fromJSONArray (JSONArray array){
        ArrayList<ImageResult> results = new ArrayList<>();
        for(int i=0; i< array.length(); i++){
            try {
                results.add(new ImageResult(array.getJSONObject(i)));
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return results;
    }
}
