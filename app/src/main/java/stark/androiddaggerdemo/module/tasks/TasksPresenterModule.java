package stark.androiddaggerdemo.module.tasks;

import dagger.Module;
import dagger.Provides;
import stark.androiddaggerdemo.db.TodoRepo;

/**
 * Created by jihongwen on 2017/6/29.
 */

@Module
public class TasksPresenterModule {
    TasksContract.ITasksView mTasksView;
    TodoRepo mTodoRepo;

    public TasksPresenterModule(TodoRepo todoRepo, TasksContract.ITasksView iTasksView) {
        mTasksView = iTasksView;
        mTodoRepo = todoRepo;
    }

    @Provides
    public TasksContract.ITasksPresenter provideTasksPresenter() {
        return new TasksPresenter(mTodoRepo, mTasksView);
    }
}
