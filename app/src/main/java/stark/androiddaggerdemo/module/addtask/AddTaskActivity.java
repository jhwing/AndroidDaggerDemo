package stark.androiddaggerdemo.module.addtask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import stark.androiddaggerdemo.R;
import stark.androiddaggerdemo.TodoApp;
import stark.androiddaggerdemo.TodoModule;
import stark.androiddaggerdemo.base.BaseActivity;
import stark.androiddaggerdemo.db.TodoDBModule;
import stark.androiddaggerdemo.db.TodoRepo;

/**
 * Created by jihongwen on 2017/6/30.
 */

public class AddTaskActivity extends BaseActivity implements AddTaskContract.IAddTaskView {

    @BindView(value = R.id.toolbar)
    Toolbar toolbar;

    @BindView(value = R.id.addTaskContent)
    EditText addTaskContent;

    @Inject
    AddTaskContract.IAddTaskPresenter mPresenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, AddTaskActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initDaggerComponent();
    }

    private void initDaggerComponent() {
        TodoRepo todoRepo = TodoApp.todoComponent(this).getTodoRepo();
        DaggerAddTaskComponent.builder()
                .addTaskPresenterModule(new AddTaskPresenterModule(todoRepo, this))
                .build()
                .inject(this);
    }

    @OnClick(value = R.id.fab_add_done)
    public void onFabClick() {
        String taskContent = addTaskContent.getText().toString();
        mPresenter.addTask(taskContent, System.currentTimeMillis());
    }


    @Override
    public void taskContentEmptyToast() {
        Snackbar.make(addTaskContent, "task cannot be empty", Snackbar.LENGTH_SHORT).show();
    }
}
