package stark.androiddaggerdemo.module.addtask;

import dagger.Module;
import dagger.Provides;
import stark.androiddaggerdemo.TodoModule;
import stark.androiddaggerdemo.db.TodoDBModule;
import stark.androiddaggerdemo.db.TodoRepo;

/**
 * Created by jihongwen on 2017/6/30.
 */

@Module
public class AddTaskPresenterModule {

    AddTaskContract.IAddTaskView mAddTaskView;
    TodoRepo mTodoRepo;

    AddTaskPresenterModule(TodoRepo todoRepo, AddTaskContract.IAddTaskView iAddTaskView) {
        mTodoRepo = todoRepo;
        mAddTaskView = iAddTaskView;
    }

    @Provides
    AddTaskContract.IAddTaskPresenter provideAddTaskPresenter() {
        return new AddTaskPresenter(mTodoRepo, mAddTaskView);
    }


}
