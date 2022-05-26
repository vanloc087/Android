package com.example.appone_provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import java.util.HashMap;

public class MyContentProvider extends ContentProvider {
    static  final String AUTHORITY = "com.example.appone_provider";
    static  final String CONTENT_PROVIDER = "contentprovider";
    static  final String URL = "content://"+AUTHORITY+"/"+CONTENT_PROVIDER;
    static  final Uri  CONTENT_URI = Uri.parse(URL);
    static  final String PRODUCT_TABLE = "Products";
    private SQLiteDatabase db;
    static final int ALL = 1;
    static final int ONE = 2;
    static  final UriMatcher uriMactcher;
    static {
        uriMactcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMactcher.addURI(AUTHORITY,PRODUCT_TABLE,ONE);
        uriMactcher.addURI(AUTHORITY,PRODUCT_TABLE+"/#",ALL);
    }
    private static HashMap<String,String> PROJECTION_MAP;

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int rowsDeleted = 0;
        rowsDeleted = db.delete(PRODUCT_TABLE, selection, selectionArgs);
//        throw new UnsupportedOperationException("Not yet implemented");
        return rowsDeleted;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }



    @Override
    public boolean onCreate() {

        Context context = getContext();
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        if(db == null)
            return false;
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(PRODUCT_TABLE);
        switch (uriMactcher.match(uri)){
            case ALL:
                queryBuilder.setProjectionMap(PROJECTION_MAP);
                break;
            case ONE:
                queryBuilder.appendWhere("id="+uri.getPathSegments().get(0));
        }
        Cursor cursor = queryBuilder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long number_row = db.insert(PRODUCT_TABLE,"",values);
        int res = uriMactcher.match(uri);
        System.out.println(res);
        if(number_row > 0){
            Uri uri1 = ContentUris.withAppendedId(CONTENT_URI,number_row);
            getContext().getContentResolver().notifyChange(uri1,null);
            return uri1;
        }
        throw new SQLException("Faile to add record into "+uri);
    }
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;
        int res = uriMactcher.match(uri);
        count = db.update(PRODUCT_TABLE, values, selection, selectionArgs);


//        System.out.println(uri);
//        System.out.println(uriMactcher);
//        switch (res) {
//            case ALL:
//                count = db.update(PRODUCT_TABLE, values, selection, selectionArgs);
//                break;
//
//            case ONE:
//                count = db.update(PRODUCT_TABLE, values,
//                        "_id = " + uri.getPathSegments().get(1) +
//                                (!TextUtils.isEmpty(selection) ? "AND (" +selection + ')' : ""), selectionArgs);
//                break;
//            default:
//                throw new IllegalArgumentException("Unknown URI: " + uri);
//
//        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

}