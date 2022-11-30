package cnu.adventure;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, int version) {
        super(context, "login.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS LOGIN (ID INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT, LOGIN_TYPE INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOGIN");
        onCreate(sqLiteDatabase);
    }

    public Cursor getLastLogin() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query("LOGIN", new String[]{"id", "username", "password", "login_type"}
                , null, null, null, null, null);
    }
}
