package stark.androiddaggerdemo;

import android.app.Application;
import android.content.Context;

import stark.androiddaggerdemo.db.DaggerTodoComponent;
import stark.androiddaggerdemo.db.TodoComponent;
import stark.androiddaggerdemo.db.TodoDBModule;

/**
 * Created by jihongwen on 2017/6/22.
 */

public class TodoApp extends Application {

    TodoComponent todoComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        todoComponent = DaggerTodoComponent.builder()
                .todoDBModule(new TodoDBModule())
                .todoModule(new TodoModule(this))
                .build();
    }

    public static TodoComponent todoComponent(Context context) {
        return ((TodoApp) context.getApplicationContext()).todoComponent;
    }
}
