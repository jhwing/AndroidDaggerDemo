package stark.androiddaggerdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import stark.androiddaggerdemo.utils.DateFormatUtil;

/**
 * Created by jihongwen on 2017/6/28.
 */

public class TodoDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "todo.db";

    public TodoDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoItem.CREATE_TABLE);
        // init test data
        TodoItemModel.InsertRow insertRow = new TodoItemModel.InsertRow(db);
        insertRow.bind("dagger", DateFormatUtil.parseFormatDate("2017-06-10 22:30:13"));
        insertRow.program.executeInsert();
        insertRow.bind("dagger2", DateFormatUtil.parseFormatDate("2017-06-20 22:30:13"));
        insertRow.program.executeInsert();
        insertRow.bind("dagger3", DateFormatUtil.parseFormatDate("2017-06-30 22:30:13"));
        insertRow.program.executeInsert();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
