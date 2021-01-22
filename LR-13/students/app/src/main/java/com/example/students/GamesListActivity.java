package com.example.students;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.ContentValues;
import  android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class GamesListActivity extends AppCompatActivity {
    public static final String AUTHOR = "author";
    private Cursor cursor;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);
        Intent intent = getIntent();
        int author = intent.getIntExtra(AUTHOR, 0); ///

        ListView listView = (ListView) findViewById(R.id.gameList);
        SimpleCursorAdapter adapter = getDataFromDB(author);
        if (adapter != null) {
            listView.setAdapter(adapter);
        }
    }
    private  SimpleCursorAdapter getDataFromDB (int gameId) {
        SimpleCursorAdapter listAdapter = null;

        SQLiteOpenHelper sqLiteOpenHelper = new GamesDatabaseHelper(this);
        try {
            db = sqLiteOpenHelper.getReadableDatabase();
            cursor = db.rawQuery("select g.id _id, name, author\n" +
                    "from games g inner join authors a on g.author_id = a.id\n" +
                    "where a.id = ?", new String[]{Integer.toString(gameId)});
            listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"name"},
                    new int[]{android.R.id.text1},
                    0);
        }catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable",
                    Toast.LENGTH_SHORT);
                    toast.show();
        }
        return listAdapter;

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    public void onSendBtnClick(View view){
        TextView textView = (TextView) findViewById(R.id.text);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Список iгор");
        startActivity(intent);
    }

}