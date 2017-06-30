package stark.androiddaggerdemo.db;

import android.database.Cursor;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by jihongwen on 2017/6/26.
 */
@AutoValue
public abstract class TodoItem implements TodoItemModel, Parcelable {

    public static final TodoItemModel.Creator<TodoItem> CREATOR = new TodoItemModel.Creator<TodoItem>() {
        @Override
        public TodoItem create(long id, @Nullable String content, @Nullable Long ctime) {
            return new AutoValue_TodoItem(id, content, ctime);
        }
    };

    public static final Function<Cursor, TodoItem> MAPPER = new Function<Cursor, TodoItem>() {
        @Override
        public TodoItem apply(@NonNull Cursor cursor) throws Exception {
            return FACTORY.getAllDataMapper().map(cursor);
        }
    };

    public static final Factory<TodoItem> FACTORY = new Factory(CREATOR);
    
}
