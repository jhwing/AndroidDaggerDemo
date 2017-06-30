package stark.androiddaggerdemo.module.addtask;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import javax.inject.Inject;

import stark.androiddaggerdemo.db.TodoRepo;

/**
 * Created by jihongwen on 2017/6/30.
 */

public class AddTaskPresenter implements AddTaskContract.IAddTaskPresenter {

    TodoRepo mTodoRepo;
    AddTaskContract.IAddTaskView mIAddTaskView;

    @Inject
    public AddTaskPresenter(TodoRepo todoRepo, AddTaskContract.IAddTaskView iAddTaskView) {
        mTodoRepo = todoRepo;
        mIAddTaskView = iAddTaskView;
    }

    @Override
    public void unBind(Context context) {

    }

    @Override
    public void addTask(String taskContent, long currentTimeMillis) {
        if (TextUtils.isEmpty(taskContent)) {
            mIAddTaskView.taskContentEmptyToast();
            return;
        }
        long row = mTodoRepo.addTask(taskContent, currentTimeMillis);
        Log.d("addTask", "row :" + row);
        mIAddTaskView.onFinish();
    }
}
