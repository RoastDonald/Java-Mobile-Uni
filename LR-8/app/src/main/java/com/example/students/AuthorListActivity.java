package com.example.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.ShareActionProvider;


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.author_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "test message");
        shareActionProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }

    public void AddAuthorClick(View view) {
        Intent intent = new Intent (AuthorListActivity.this,
                AddGameAuthorActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_author:
                startActivity(
                        new Intent(this, AddGameAuthorActivity.class)
                );
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}