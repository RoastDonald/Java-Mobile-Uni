package com.example.students;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AuthorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_list);
        ArrayAdapter<Games_genre>  games_genreArrayAdapter = new ArrayAdapter<Games_genre>(
                this,
                android.R.layout.simple_list_item_1,
                Games_genre.getGenres()
        );

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String author_name = ((Games_genre)adapterView.getItemAtPosition(i)).toString();
                Intent intent = new Intent (AuthorListActivity.this, genreGamesActivity.class);
                intent.putExtra(genreGamesActivity.AUTHOR, author_name);
                startActivity(intent);
            }
        };

        ListView listView = findViewById(R.id.author_list_view);
        listView.setAdapter(games_genreArrayAdapter);
        listView.setOnItemClickListener(listener);
    }

}