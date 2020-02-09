//package com.example.datexheck.database;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.content.res.AssetManager;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.text.TextUtils;
//import android.util.Log;
//
//import androidx.annotation.Nullable;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    private static final String TAG = DatabaseHelper.class.getName();
//
//    private static DatabaseHelper mInstance = null;
//    private final Context context;
//    SQLiteDatabase database;
//
//   //creating database constants
//   private static final String DATABASE_NAME = "product.db";
//    private static final Integer DATABASE_VERSION = 1;
//    private static final String TABLE_NAME = "products";
//
//    //create constants for the table's column name
//    private static final String COL_ID = "ID";
//    private static final String COL_NAME = "NAME";
//    private static final String COL_EXPDATE = "EXPIRY";
//    private static final String COL_BARCODE = "BARCODE";
//
//
//
//    private static final String CREATE_TABLE_ST = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            COL_NAME + " TEXT, " +
//            COL_EXPDATE + " TEXT, " +
//            COL_BARCODE+ " INTEGER )";
//
//    private static final String CREATE_TABLE_ST_UP_TO_DATE = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            COL_NAME + " TEXT, " +
//            COL_EXPDATE+ " TEXT, " +
//            COL_BARCODE + " INTEGER )" ;
//
//    private static final String GET_ALL_ST = "SELECT * FROM " + TABLE_NAME;
//    private static final String GET_LAST_INSERTED_ID = "SELECT SEQ FROM SQLITE_SEQUENCE WHERE NAME = ?";
//    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + "= ?";
//
//    public static synchronized DatabaseHelper getInstance(Context ctx) {
//        if (mInstance == null) {
//            mInstance = new DatabaseHelper(ctx.getApplicationContext());
//        }
//        return mInstance;
//    }
//
//    public DatabaseHelper(@Nullable Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        this.context = context;
//    }
//
//
//    public void open() throws SQLException {
//        database = this.getWritableDatabase();
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//
//        sqLiteDatabase.execSQL(CREATE_TABLE_ST_UP_TO_DATE);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
//
//        Log.e(TAG, "Updating table from " + oldVersion + " to " + newVersion);
//        // You will not need to modify this unless you need to do some android specific things.
//        // When upgrading the database, all you need to do is add a file to the assets folder and name it:
//        // from_1_to_2.sql with the version that you are upgrading to as the last version.
//
//        for (int i = oldVersion; i < newVersion; ++i) {
//            String migrationFileName = String.format("from_%d_to_%d.sql", i, (i + 1));
//            migrationFileName = "databaseFiles/scripts/" + migrationFileName;
//            Log.d(TAG, "Looking for migration file: " +  migrationFileName);
//            readAndExecuteSQLScript(sqLiteDatabase, context, migrationFileName);
//        }
//
//
//
//
//    }
//
//
//    //adding to the database
//    public Long insert(String name, String expDate, Integer barcode) {
//        //create an instance of SQLITE database
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_NAME, name);
//        contentValues.put(COL_EXPDATE, expDate);
//        contentValues.put(COL_BARCODE, barcode);
//
//
//        long result = db.insert(TABLE_NAME, null, contentValues);
//
//        return result;
//    }
//
//
//    public Cursor getAll() {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        return db.rawQuery(GET_ALL_ST, null);
//    }
//
//
//    //update
//    public boolean update(Integer id, String name, String expDate, Integer barcode) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_ID, id);
//        contentValues.put(COL_NAME, name);
//        contentValues.put(COL_EXPDATE, expDate);
//        contentValues.put(COL_BARCODE, barcode);
//
//        int numRowsUpdated = db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id.toString()});
//
//        return numRowsUpdated != 1;
//    }
//
//    public boolean delete(Integer id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        int numOfAffectedRows = db.delete(TABLE_NAME, "ID = ?", new String[]{id.toString()});
//        return numOfAffectedRows != -1;
//    }
//
//    public List<Product> getProducts(){
//        List<Product> products = new ArrayList<>();
//        Cursor cursor = getAll();
//
//        if(cursor.getCount() > 0){
//
//            Product product;
//
//            while (cursor.moveToNext()) {
//                Long id = cursor.getLong(0);
//                String name = cursor.getString(1);
//                String expDate = cursor.getString(2);
//                Integer barcode = cursor.getInt(3);
//
//
//               product = new Product(id, name, expDate, barcode);
//               products.add(product);
//            }
//        }
//        cursor.close();
//        return products;
//
//    }
//
//    private Cursor getSequenceCursor(String tableName){
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.rawQuery(GET_LAST_INSERTED_ID, new String[]{tableName});
//    }
//
//    public Long getLastInsertedIdInTable(String tableName){
//        Long lastId = -999L;
//        Cursor cursor = getSequenceCursor(tableName);
//
//        if(cursor.getCount()>0){
//            while (cursor.moveToNext()){
//                lastId = cursor.getLong(0);
//            }
//        }
//        cursor.close();
//        return lastId;
//    }
//
//    public Product getProduct(Long id){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Product product = null;
//
//        Cursor cursor = db.rawQuery(GET_PRODUCT_BY_ID, new String[]{id.toString()});
//
//        if(cursor.getCount() > 0)
//            while (cursor.moveToNext()){
//                String name = cursor.getString(1);
//                String expDate = cursor.getString(2);
//                Integer barcode = cursor.getInt(3);
//
//
//                product = new Product(id, name, expDate, barcode);
//
//            }
//        cursor.close();
//        return product;
//
//    }
//
//
//    private void readAndExecuteSQLScript(SQLiteDatabase db, Context ctx, String fileName) {
//        if (TextUtils.isEmpty(fileName)) {
//            Log.d(TAG, "SQL script file name " + fileName + " is empty");
//            return;
//        }
//
//        Log.d(TAG, "Script " + fileName + " found. Executing...");
//        AssetManager assetManager = ctx.getAssets();
//        BufferedReader reader = null;
//        InputStream is = null;
//        InputStreamReader isr = null;
//        try {
//            is = assetManager.open(fileName);
//            isr = new InputStreamReader(is);
//            reader = new BufferedReader(isr);
//            executeSQLScript(db, reader);
//        } catch (IOException e) {
//            Log.e(TAG, "IOException:", e);
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                    isr.close();
//                    is.close();
//                } catch (IOException e) {
//                    Log.e(TAG, "IOException:", e);
//                }
//            }
//        }
//
//    }
//
//    private void executeSQLScript(SQLiteDatabase db, BufferedReader reader) throws IOException {
//        String line;
//        StringBuilder statement = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            statement.append(line);
//            statement.append("\n");
//            if (line.endsWith(";")) {
//                db.execSQL(statement.toString());
//                statement = new StringBuilder();
//            }
//        }
//    }
//}
