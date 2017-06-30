package stark.androiddaggerdemo.module.tasks;

import java.util.List;

import stark.androiddaggerdemo.base.mvp.IPresenter;
import stark.androiddaggerdemo.base.mvp.IView;
import stark.androiddaggerdemo.db.TodoItem;

/**
 * Created by jihongwen on 2017/6/28.
 */

public interface TasksContract {

    interface ITasksView extends IView {

        void bindData(List<TodoItem> todoItems);

        void showAddTask();
    }

    interface ITasksPresenter extends IPresenter {

        void initData();

        void addTask();
    }
}
