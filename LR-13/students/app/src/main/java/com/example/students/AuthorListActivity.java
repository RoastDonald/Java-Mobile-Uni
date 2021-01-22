package com.example.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import  android.content.Intent;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_list);
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Games_genre author = ((Games_genre) adapterView.getItemAtPosition(i));
                Intent intent =new Intent(AuthorListActivity.this, genreGamesActivity.class);
                intent.putExtra(GamesListActivity.AUTHOR, author.getId());
                startActivity(intent);
            }
        };
        ListView listView = (ListView) findViewById(R.id.author_list_view);
        listView.setOnItemClickListener(listener);
        ArrayAdapter<Games_genre> adapter = new ArrayAdapter<Games_genre>(
                this,
                android.R.layout.simple_list_item_1,
                Games_genre.httpGetGenre()
        );
        listView.setAdapter(adapter);
    }
    public void onGenerAddClick(View view){
        startActivity(
                new Intent(this, AddGameAuthorActivity.class)
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.author_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_author:
                startActivity(
                        new Intent(this, AddGameAuthorActivity.class)
                );
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}