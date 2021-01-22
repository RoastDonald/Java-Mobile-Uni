package com.example.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class genreGamesActivity extends AppCompatActivity {
    public static final String AUTHOR = "author";
    private  Games_genre games_genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganre_games2);

        Intent intent = getIntent();
        int author = intent.getIntExtra(AUTHOR, 0);
        games_genre = null;
        games_genre = Games_genre.httpGetGenre(author);


if (games_genre != null) {
    EditText txtAuthor = (EditText) findViewById(R.id.editTextAuthor);
    txtAuthor.setText(games_genre.getAuthor());

    EditText txtGenre = (EditText) findViewById(R.id.editTextGenre);
    txtGenre.setText(games_genre.getGenre());

    TextView txtImageAuthor = (TextView) findViewById(R.id.authorText2);
    txtImageAuthor.setText(games_genre.getAuthor());

    TextView txtImageGenre = (TextView) findViewById(R.id.genreText2);
    txtImageGenre.setText(games_genre.getGenre());

    if (games_genre.getCountryOfIssue() == 0) {
        ((RadioButton) findViewById(R.id.radio_countryOfIssue_Usa)).setChecked(true);
    } else {
        ((RadioButton) findViewById(R.id.radio_Canada)).setChecked(true);
    }

    ((CheckBox) findViewById(R.id.CBcriticallyTestedFlg)).setChecked(games_genre.isCriticallyTestedFlg());
    ((CheckBox) findViewById(R.id.CBonSaleFlg)).setChecked(games_genre.isOnSaleFlg());
}
    }
    public void onBtnOkClick(View view) {

        SQLiteOpenHelper sqLiteOpenHelper = new GamesDatabaseHelper(this);

        ContentValues contentValues = new ContentValues();
        contentValues.put("author",
                ((TextView) findViewById(R.id.editTextAuthor)).getText().toString());
        contentValues.put("genre",
                ((TextView) findViewById(R.id.editTextGenre)).getText().toString());
        contentValues.put("countryOfIssue",
                ((RadioButton) findViewById(R.id.radio_Canada)).isChecked()?1:0);
        contentValues.put("criticallyTestedFlg",
                ((CheckBox) findViewById(R.id.CBcriticallyTestedFlg)).getText().toString());
        contentValues.put("onSaleFlg",
                ((CheckBox) findViewById(R.id.CBonSaleFlg)).isChecked()?1:0);
        Intent intent = getIntent();
        int author = intent.getIntExtra(AUTHOR, 0);

        try{
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            db.update("authors", contentValues, "id=?", new String[]{Integer.toString(author)}
            );
            db.close();
            NavUtils.navigateUpFromSameTask(this);
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
           toast.show();
        }

    
}      public void onBtnGameListClick (View view) {

        Intent newIntent = new Intent (this, GamesListActivity.class);
        newIntent.putExtra(GamesListActivity.AUTHOR, games_genre.getId());
        startActivity(newIntent);
    }
    public void onDelete(View view) {
        Intent intent = getIntent();
        int author = intent.getIntExtra(AUTHOR,0);
        Games_genre.httpRemoveAuthor(author);
        NavUtils.navigateUpFromSameTask(this);
        startActivity(
                new Intent(this, GamesListActivity.class)
        );
    }
 }

