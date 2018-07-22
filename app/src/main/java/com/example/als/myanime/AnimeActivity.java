package com.example.als.myanime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AnimeActivity extends AppCompatActivity {
    private String URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest arrayRequest;
    private RequestQueue requestQueue;
    private List<Anime> list = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.recycle_view);
        jsoncall();
    }

    private void jsoncall() {
        arrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Anime anime = new Anime();
                        anime.setName(jsonObject.getString("name"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setCategorie(jsonObject.getString("categorie"));
                        anime.setEpisode(jsonObject.getInt("episode"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setImage(jsonObject.getString("img"));

                        list.add(anime);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(AnimeActivity.this, getString(R.string.list) + String.valueOf(list.size()), Toast.LENGTH_SHORT).show();
                Toast.makeText(AnimeActivity.this, list.get(1).toString(), Toast.LENGTH_SHORT).show();
                setrecycleview(list);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(AnimeActivity.this);
        requestQueue.add(arrayRequest);
    }

    private void setrecycleview(List<Anime> list) {
        AnimeAdapter adapter = new AnimeAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
