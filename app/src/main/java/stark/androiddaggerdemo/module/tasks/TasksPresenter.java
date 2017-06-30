package stark.androiddaggerdemo.module.tasks;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import stark.androiddaggerdemo.db.TodoItem;
import stark.androiddaggerdemo.db.TodoRepo;


/**
 * Created by jihongwen on 2017/6/29.
 */

public class TasksPresenter implements TasksContract.ITasksPresenter, Consumer<List<TodoItem>> {

    Disposable disposable;

    TasksContract.ITasksView mTasksView;
    TodoRepo mTodoRepo;

    @Inject
    public TasksPresenter(TodoRepo todoRepo, TasksContract.ITasksView iTasksView) {
        mTodoRepo = todoRepo;
        mTasksView = iTasksView;
    }

    @Override
    public void unBind(Context context) {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public void initData() {
        disposable = mTodoRepo.getAllData().subscribe(this);
    }

    @Override
    public void addTask() {
        mTasksView.showAddTask();
    }

    @Override
    public void accept(@NonNull List<TodoItem> todoItems) throws Exception {
        mTasksView.bindData(todoItems);
    }
}
