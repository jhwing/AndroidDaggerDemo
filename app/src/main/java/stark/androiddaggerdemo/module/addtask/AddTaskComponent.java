package stark.androiddaggerdemo.module.addtask;

import dagger.Component;

/**
 * Created by jihongwen on 2017/6/30.
 */

@Component(modules = AddTaskPresenterModule.class)
public interface AddTaskComponent {
    
    void inject(AddTaskActivity addTaskActivity);
}
