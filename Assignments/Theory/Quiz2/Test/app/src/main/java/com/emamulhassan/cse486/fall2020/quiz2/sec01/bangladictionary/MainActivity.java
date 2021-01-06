package com.emamulhassan.cse486.fall2020.quiz2.sec01.bangladictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button wordSave, dictionary;
    private EditText engWord, benWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordSave = (Button) findViewById(R.id.save_word_btn);
        dictionary = (Button) findViewById(R.id.save_dictionary_btn);
        engWord = (EditText) findViewById(R.id.input_eng_word);
        benWord = (EditText) findViewById(R.id.input_ben_word);


        wordSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                SaveToDictionary();

            }
        });




    }

    private void SaveToDictionary()
    {
        String englishWord = engWord.getText().toString();
        String banglaWord = benWord.getText().toString();

        if(TextUtils.isEmpty(englishWord))
        {
            Toast.makeText(this, "Please Enter a English Word", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(banglaWord))
        {
            Toast.makeText(this, "Please Enter a Bangla Word", Toast.LENGTH_SHORT).show();
        }

        else
        {
            SaveWord(englishWord, banglaWord);
        }


    }

    private void SaveWord(String englishWord, String banglaWord)
    {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (!(dataSnapshot.child("Translation").child(englishWord).exists()))
                {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("Bangla Word", banglaWord);

                    RootRef.child("Translation").child(englishWord).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(MainActivity.this, "Congratulations, Word Added Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(MainActivity.this, "Network Error: Please try again!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else
                {
                    Toast.makeText(MainActivity.this, "This " + englishWord + " Already Exists.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}