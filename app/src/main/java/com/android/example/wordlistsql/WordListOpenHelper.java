package com.android.example.wordlistsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WordListOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = WordListOpenHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String WORD_LIST_TABLE = "word_entries";
    private static final String DATABASE_NAME = "wordlist";
    private static final String KEY_ID = "_id";
    private static final String KEY_WORD = "word";
    private static final String[] COLUMNS = {KEY_ID, KEY_WORD};
    private static final String WORD_LIST_TABLE_CREATE = "CREATE TABLE " +
            WORD_LIST_TABLE +
            " (" +
            KEY_ID +
            " INTEGER PRIMARY KEY, " +
            KEY_WORD +
            " TEXT );";

    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;

    public WordListOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WORD_LIST_TABLE_CREATE);
        fillDatabaseWithData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void fillDatabaseWithData(SQLiteDatabase db) {
        String[] words = {"Android", "Adapter", "ListView", "AsyncTask", "Android Studio", "SQLiteDatabase", "SQLOpenHelper", "Data model", "ViewHolder", "Android Performance", "OnClickListener" };
        ContentValues values = new ContentValues();
        for (int i = 0; i < words.length; i++) {
            values.put(KEY_WORD, words[i]);
            db.insert(WORD_LIST_TABLE, null, values);
        }
    }
}
