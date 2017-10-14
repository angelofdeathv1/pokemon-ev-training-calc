package mx.cetys.aarambula.android.pokemonevtrainingcalc.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AngelArambula on 9/22/17.
 */

public class DBUtils extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Banpatito.db";
    public static final int DATABASE_VERSION = 1;

    public static final String CUSTOMER_TABLE_NAME = "CUSTOMERS";
    public static final String CUSTOMER_ID = "_id";
    public static final String CUSTOMER_NAME = "_name";
    public static final String CUSTOMER_OPERATIONS = "_operations";
    public static final String CUSTOMER_POSITION = "_position";

    private static final String DATABASE_CREATE = "CREATE TABLE " +
            CUSTOMER_TABLE_NAME +
            " (" +
            CUSTOMER_ID +
            " integer primary key autoincrement," +
            CUSTOMER_NAME +
            " text not null," +
            CUSTOMER_OPERATIONS +
            " integer not null," +
            CUSTOMER_POSITION +
            " integer not null" +
            ")";

    public DBUtils(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CUSTOMER_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
