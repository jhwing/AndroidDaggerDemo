package stark.androiddaggerdemo.db;

import android.util.Log;

import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqldelight.SqlDelightStatement;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by jihongwen on 2017/6/29.
 */

@Singleton
public class TodoRepo {

    BriteDatabase mBriteDatabase;

    @Inject
    TodoRepo(BriteDatabase briteDatabase) {
        mBriteDatabase = briteDatabase;
    }

    public Observable<List<TodoItem>> getAllData() {
        Log.d("jihongwen", "getAllData mBriteDatabase:" + mBriteDatabase);
        SqlDelightStatement statement = TodoItem.FACTORY.getAllData();
        return mBriteDatabase.createQuery(TodoItem.TABLE_NAME, statement.statement, statement.args)
                .mapToList(TodoItem.MAPPER)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public long addTask(String content, long currentTimeMillis) {
        Log.d("jihongwen", "addTask mBriteDatabase:" + mBriteDatabase);
        TodoItemModel.Marshal marshal = new TodoItemModel.Marshal(null);
        marshal.content(content);
        marshal.ctime(currentTimeMillis);
        return mBriteDatabase.insert(TodoItem.TABLE_NAME, marshal.asContentValues());
    }
}
