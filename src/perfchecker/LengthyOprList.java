package perfchecker;

import java.util.ArrayList;

public class LengthyOprList {
	public static ArrayList<String> list;
	public static String getSecond(String s1, String s2) {
		return s2;
	}
	static {
		list = new ArrayList<String>();
	    list.add(getSecond("java.net.URL", "<java.net.URL: java.net.URLConnection openConnection()>"));
	    list.add(getSecond("java.net.URL", "<java.net.URL: java.io.InputStream openStream()>"));
	    list.add(getSecond("java.net.URL", "<java.net.URL: java.lang.Object getContent()>"));
	    list.add(getSecond("java.net.URL", "<java.net.URL: java.lang.Object getContent(java.lang.Class[])>"));
	    list.add(getSecond("java.net.URLConnection", "<java.net.URLConnection: java.io.InputStream getInputStream()>"));
	    list.add(getSecond("java.net.URLConnection", "<java.net.URLConnection: java.io.OutputStream getOutputStream()>"));
	    list.add(getSecond("java.net.URLConnection", "<java.net.URLConnection: java.lang.Object getContent()>"));
	    list.add(getSecond("java.net.URLConnection", "<java.net.URLConnection: java.lang.Object getContent(java.lang.Class[])>"));
	    list.add(getSecond("java.net.URLConnection", "<java.net.URLConnection: java.lang.String getContentEncoding()>"));
	    list.add(getSecond("java.net.URLConnection", "<java.net.URLConnection: java.lang.String getContentType()>"));
	    list.add(getSecond("java.net.URLConnection", "<java.net.URLConnection: int getContentLength()>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: void execSQL(java.lang.String)>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: void execSQL(java.lang.String,java.lang.Object[])>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor query(java.lang.String,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,java.lang.String,java.lang.String,java.lang.String)>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor query(boolean,java.lang.String,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,java.lang.String,java.lang.String,java.lang.String,android.os.CancellationSignal)>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor query(java.lang.String,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,java.lang.String,java.lang.String)>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor query(boolean,java.lang.String,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,java.lang.String,java.lang.String,java.lang.String)>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor queryWithFactory(android.database.sqlite.SQLiteDatabase$CursorFactory,boolean,java.lang.String,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,java.lang.String,java.lang.String,java.lang.String,android.os.CancellationSignal)>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor queryWithFactory(android.database.sqlite.SQLiteDatabase$CursorFactory,boolean,java.lang.String,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,java.lang.String,java.lang.String,java.lang.String)>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor rawQuery(java.lang.String,java.lang.String[],android.os.CancellationSignal)>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor rawQuery(java.lang.String,java.lang.String[])>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor rawQueryWithFactory(android.database.sqlite.SQLiteDatabase$CursorFactory,java.lang.String,java.lang.String[],java.lang.String)>"));
	    list.add(getSecond("android.database.sqlite.SQLiteDatabase", "<android.database.sqlite.SQLiteDatabase: android.database.Cursor rawQueryWithFactory(android.database.sqlite.SQLiteDatabase$CursorFactory,java.lang.String,java.lang.String[],java.lang.String,android.os.CancellationSignal)>"));
	    list.add(getSecond("android.context.ContextWrapper", "<android.context.ContextWrapper: java.io.FileInputStream openFileInput(java.lang.String)>"));
	    list.add(getSecond("android.context.ContextWrapper", "<android.context.ContextWrapper: java.io.FileOutputStream openFileOutput(java.lang.String,int)>"));
	    list.add(getSecond("java.io.Reader", "<java.io.Reader: int read()>"));
	    list.add(getSecond("java.io.Reader", "<java.io.Reader: int read(char[])>"));
	    list.add(getSecond("java.io.Reader", "<java.io.Reader: int read(java.nio.CharBuffer)>"));
	    list.add(getSecond("java.io.InputStreamReader", "<java.io.InputStreamReader: int read()>"));
	    list.add(getSecond("java.io.InputStreamReader", "<java.io.InputStreamReader: int read(char[],int,int)>"));
	    list.add(getSecond("java.io.BufferedReader", "<java.io.BufferedReader: int read()>"));
	    list.add(getSecond("java.io.BufferedReader", "<java.io.BufferedReader: int read(char[],int,int)>"));
	    list.add(getSecond("java.io.BufferedReader", "<java.io.BufferedReader: java.lang.String readLine()>"));
	    list.add(getSecond("java.io.Writer", "<java.io.Writer: java.io.Writer append(char)>"));
	    list.add(getSecond("java.io.Writer", "<java.io.Writer: java.io.Writer append(java.lang.CharSequence)>"));
	    list.add(getSecond("java.io.Writer", "<java.io.Writer: java.io.Writer append(java.lang.CharSequence,int,int)>"));
	    list.add(getSecond("java.io.Writer", "<java.io.Writer: void write(char[])>"));
	    list.add(getSecond("java.io.Writer", "<java.io.Writer: void write(int)>"));
	    list.add(getSecond("java.io.Writer", "<java.io.Writer: void write(java.lang.String)>"));
	    list.add(getSecond("java.io.Writer", "<java.io.Writer: void write(java.lang.String,int,int)>"));
	    list.add(getSecond("java.io.BufferedWriter", "<java.io.BufferedWriter: void write(char[],int,int)>"));
	    list.add(getSecond("java.io.BufferedWriter", "<java.io.BufferedWriter: void write(int)>"));
	    list.add(getSecond("java.io.BufferedWriter", "<java.io.BufferedWriter: void write(java.lang.String,int,int)>"));
	    list.add(getSecond("android.graphics.BitmapFactory", "<android.graphics.BitmapFactory: android.graphics.Bitmap decodeFile(java.lang.String,android.graphics.BitmapFactory$Options)>"));
	    list.add(getSecond("android.graphics.Bitmap", "<android.graphics.Bitmap: boolean compress(android.graphics.Bitmap$CompressFormat,int,java.io.OutputStream)>"));
	}
}
