package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganre_games2);

        Intent intent = getIntent();
        int author = intent.getIntExtra(AUTHOR, 0);
        Games_genre games_genre = null;

        SQLiteOpenHelper sqliteHelper = new GamesDatabaseHelper(this);
        try {
            SQLiteDatabase db = sqliteHelper.getReadableDatabase();
            Cursor cursor = db.query("Authors", new String[] {"author", "genre", "countryOfIssue", "criticallyTestedFlg", "onSaleFlg", "id"},
                    "id=?", new String[]{Integer.toString(author)}, null, null, null);
            if(cursor.moveToFirst()){
                games_genre = new Games_genre(
                        cursor.getInt(5),
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        (cursor.getInt(3) > 0),
                        (cursor.getInt(4) > 0)
                );
            }else{
                Toast toast = Toast.makeText(this,
                        "Can`t find author with id" + Integer.toString(Integer.parseInt(Integer.toString(author))),Toast.LENGTH_SHORT);
            }
            cursor.close();
            db.close();
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this,
                    "Database unavailabale", Toast.LENGTH_SHORT);
            toast.show();
        }

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
        String outString = "Студiя " + ((TextView) findViewById(R.id.authorText2)).getText() + "\n";
        outString +=  "Жанри " + ((TextView) findViewById(R.id.genreText2)).getText() + "\n" + "Країна виробнитства ";
        if(((RadioButton) findViewById(R.id.radio_countryOfIssue_Usa)).isChecked()){
            outString +=  ((TextView) findViewById(R.id.radio_countryOfIssue_Usa)).getText() + "\n";
         }else{
            outString +=  ((TextView) findViewById(R.id.radio_Canada)).getText() + "\n";
        }
        if(((CheckBox)findViewById(R.id.CBcriticallyTestedFlg)).isChecked()){
            outString += "Оцiнена критиками\n";
        }else{
            outString += "Не була оцiнена критиками\n";
        }
        outString += "В даний час ";
        if(((CheckBox)findViewById(R.id.CBonSaleFlg)).isChecked()){
            outString += "у продажу\n";
        }else{
            outString += "ізнят з продажу\n";
        }
        Toast.makeText(this, outString, Toast.LENGTH_LONG).show();
    
}      public void onBtnGameListClick (View view) {
        Intent localIntent = getIntent();
        String games = localIntent.getStringExtra(AUTHOR);

        Intent newIntent = new Intent (this, GamesListActivity.class);
        newIntent.putExtra(GamesListActivity.AUTHOR, games);
        startActivity(newIntent);
    }
}
