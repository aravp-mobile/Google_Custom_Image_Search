package com.arvind.ooug.taskgci.net;

import android.content.Context;
import android.widget.Toast;

import com.arvind.ooug.taskgci.R;
import com.arvind.ooug.taskgci.models.ImageFilter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SearchClient {
    private static final String API_BASE_URL = "https://www.googleapis.com/customsearch/v1?";
    private static final String API_KEY = "AIzaSyDRgr4Z6OUzfJB5Drdz8fIs_4cRULUfNek";
    private static final String CX_KEY = "004528206755545697344:d7tbp2chizr";
    private AsyncHttpClient client;

    public SearchClient(){
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl){
        return API_BASE_URL + relativeUrl;   }

    public String getFilterUrl (ImageFilter imageFilter){
        String filterUrl = "";
        if (imageFilter.getColor() != null && !imageFilter.getColor().equals("Any")){
            filterUrl += "&imgDominantColor=" + imageFilter.getColor();
        }
        if (imageFilter.getSize() != null && !imageFilter.getSize().equals("Any")){
            filterUrl += "&imgSize=" + imageFilter.getSize();
        }
        if (imageFilter.getType() != null && !imageFilter.getType().equals("Any")){
            filterUrl += "&imgType=" + imageFilter.getType();
        }
        if (imageFilter.getSite() != null && !imageFilter.getSite().equals("")){
            filterUrl += "&siteSearch=" + imageFilter.getSite();
        }

        return filterUrl;
    }
    public void getSearch(final String query, int startPage, ImageFilter imageFilter, Context context, JsonHttpResponseHandler handler ){
        try {
            String url = getApiUrl("q="+ URLEncoder.encode(query,"utf-8")+"&start="+startPage+
                    "&cx="+CX_KEY+"&searchType=image"+getFilterUrl(imageFilter)+"&key="+API_KEY);
            client.get(url, handler);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            Toast.makeText(context, R.string.search_not_found, Toast.LENGTH_SHORT).show();
        }
    }
}
