package com.example.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddGameAuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game_author);
    }
    public void onAddAuthorBtnOkClick(View view) {
       EditText author = (EditText) findViewById(R.id.addTextAuthor);
       EditText genre = (EditText) findViewById(R.id.addTextGenre);

        SQLiteOpenHelper sqliteHelper = new GamesDatabaseHelper(this);
        try{
            SQLiteDatabase db = sqliteHelper.getReadableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put("author", author.getText().toString());
            contentValues.put("genre", genre.getText().toString());
            contentValues.put("countryOfIssue", 0);
            contentValues.put("criticallyTestedFlg", 0);
            contentValues.put("onSaleFlg", 0);
             db.insert ("authors", null, contentValues);
             db.close();
             NavUtils.navigateUpFromSameTask(this);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText( this,
                    "Database unavailable",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}