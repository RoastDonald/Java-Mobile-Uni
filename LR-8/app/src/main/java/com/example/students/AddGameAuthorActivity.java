package com.example.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddGameAuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game_author);
    }
    public void onAddAuthorBtnOkClick(View view) {
        EditText author = (EditText) findViewById(R.id.addTextAuthor);
        EditText genre = (EditText) findViewById(R.id.addTextGenre);
        Games_genre.addGenre(
                new Games_genre(author.getText().toString(),
                        genre.getText().toString(), 0, false, false)

        );
        NavUtils.navigateUpFromSameTask(this);
    }
}