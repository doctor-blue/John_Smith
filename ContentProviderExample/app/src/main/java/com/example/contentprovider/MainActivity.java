package com.example.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertDictionary(new Dictionary("WordSample","vn"));
        getAllDictionary();
    }

    private void insertDictionary(Dictionary dictionary) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserDictionary.Words.LOCALE, dictionary.getLocale());
        contentValues.put(UserDictionary.Words.WORD, dictionary.getWord());

        getContentResolver().insert(UserDictionary.Words.CONTENT_URI, contentValues);
    }

    private List<Dictionary> getAllDictionary() {
        ArrayList<Dictionary> dictionaries = new ArrayList<>();
        String[] projection = {UserDictionary.Words.LOCALE, UserDictionary.Words.WORD};
        Cursor cursor = getContentResolver().query(UserDictionary.Words.CONTENT_URI, projection,
                null, null, null);
        try {
            if (null!=cursor){
                int idLocale=cursor.getColumnIndex(UserDictionary.Words.LOCALE);
                int idWord=cursor.getColumnIndex(UserDictionary.Words.WORD);
                while (cursor.moveToNext()){
                    String word=cursor.getString(idWord);
                    String locale=cursor.getString(idLocale);
                    Dictionary dictionary=new Dictionary(word,locale);
                    dictionaries.add(dictionary);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            cursor.close();
        }
        return dictionaries;
    }

}

class Dictionary {
    private String word;
    private String locale;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Dictionary(String word, String locale) {
        this.word = word;
        this.locale = locale;
    }
}
