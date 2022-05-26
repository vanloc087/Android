package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "MYDB2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors(id integer primary key, name text, address text, email text);");
        sqLiteDatabase.execSQL("CREATE TABLE Books(id integer primary key, title text, id_author integer not null constraint id_author  REFERENCES Authors(id) on Delete cascade  on update cascade);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        onCreate(sqLiteDatabase);
    }


    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    void updateBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Books SET  title = ?,id_author=?  where id = ?",new String[]{book.getTitle(), book.getId_author() + "",book.getId()+""});
    }



    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        String sql = "Select * from Authors";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Author(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }

    public boolean deleteBook(Integer id){
        String sql = "DELETE FROM Books WHERE id="+id;
        SQLiteDatabase db = getWritableDatabase();
//        Cursor cursor = db.rawQuery(sql,null);
        db.delete("Books","id=?",new String[]{id.toString()});
        return true;
    }

    public Author getIdAuthor(int id){
        Author author = null;
        String sql = "Select * from Authors where id ="+id;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                author = new Author(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return author;
    }

    // Them Xoa Sua Truy Van of Books

    public int insertAuthor(Author  author){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id",author.getId()+"");
        content.put("name",author.getName()+"");
        content.put("address",author.getAddress()+"");
        content.put("email",author.getEmail()+"");

        int res = (int) db.insert("Authors",null,content);

        db.close();
        return res;
    }
    public int insertBook(Book  book){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id",book.getId()+"");
        content.put("title",book.getTitle()+"");
        content.put("id_author",book.getId_author()+"");

        int res = (int) db.insert("Books",null,content);

        db.close();
        return res;
    }

    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        String sql = "Select * from Books";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }



    public Book getIdBook(int id){
        Book book = null;
        String sql = "Select * from Books where id ="+id;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                book = new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return book;
    }
    public ArrayList<Book> getBookofAuthor(String name){
        System.out.println(name);
        ArrayList<Book> list = new ArrayList<>();

        String sql = "Select Books.id,title,id_author from Books where  Authors.id = "+name+" inner join Authors on Books.id_author = Authors.id";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }
}
