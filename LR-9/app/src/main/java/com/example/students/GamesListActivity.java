package com.example.students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import  android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

public class GamesListActivity extends AppCompatActivity {
    public static final String AUTHOR = "author";
    private float textSize = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);
        Intent intent = getIntent();
        String author = intent.getStringExtra(AUTHOR);

        ListView listView = (ListView) findViewById(R.id.gameList);
        ArrayAdapter<Game> adapter = new ArrayAdapter<Game>(
                this, android.R.layout.simple_list_item_1,
                Game.getGames(author)
        );
        listView.setAdapter(adapter);
    }
       /* String txtGames = "";

        for(Game b: Game.getGames(author)){
           txtGames+=b.getNameGame() + "\n";
        }
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(txtGames);
        textSize = textView.getTextSize();
        if(savedInstanceState != null){
            textSize = savedInstanceState.getFloat("textSize");
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        }
    }
*/
    public void onSendBtnClick(View view){
        TextView textView = (TextView) findViewById(R.id.text);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Список iгор");
        startActivity(intent);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat("textSize", textSize);
    }
}