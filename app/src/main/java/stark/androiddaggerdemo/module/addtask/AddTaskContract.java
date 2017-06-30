package stark.androiddaggerdemo.module.addtask;

import stark.androiddaggerdemo.base.mvp.IPresenter;
import stark.androiddaggerdemo.base.mvp.IView;

/**
 * Created by jihongwen on 2017/6/30.
 */

public interface AddTaskContract {

    interface IAddTaskView extends IView {

        void taskContentEmptyToast();
    }

    interface IAddTaskPresenter extends IPresenter {

        void addTask(String taskContent, long currentTimeMillis);
    }
}
