package stark.androiddaggerdemo.module.tasks;

import dagger.Component;
import stark.androiddaggerdemo.db.TodoComponent;

/**
 * Created by jihongwen on 2017/6/29.
 */

@Component(modules = TasksPresenterModule.class)
public interface TasksComponent {

    void inject(TasksActivity tasksActivity);
}
