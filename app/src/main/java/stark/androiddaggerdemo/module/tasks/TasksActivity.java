package stark.androiddaggerdemo.module.tasks;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import stark.androiddaggerdemo.R;
import stark.androiddaggerdemo.TodoApp;
import stark.androiddaggerdemo.TodoModule;
import stark.androiddaggerdemo.base.BaseActivity;
import stark.androiddaggerdemo.db.TodoDBModule;
import stark.androiddaggerdemo.db.TodoItem;
import stark.androiddaggerdemo.db.TodoRepo;
import stark.androiddaggerdemo.module.addtask.AddTaskActivity;
import stark.androiddaggerdemo.utils.DateFormatUtil;

/**
 * Created by jihongwen on 2017/6/28.
 */

public class TasksActivity extends BaseActivity implements TasksContract.ITasksView {

    @BindView(value = R.id.toolbar)
    Toolbar toolbar;

    @BindView(value = R.id.todoListView)
    RecyclerView todoListView;

    TodoListAdapter mAdapter;

    @Inject
    TasksContract.ITasksPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        todoListView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TodoListAdapter(this);
        todoListView.setAdapter(mAdapter);
        initDaggerComponent();
        presenter.initData();
    }

    @OnClick(value = R.id.fab_add)
    public void onFabClick() {
        presenter.addTask();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unBind(this);
    }

    private void initDaggerComponent() {
        TodoRepo todoRepo = TodoApp.todoComponent(this).getTodoRepo();
        DaggerTasksComponent.builder()
                .tasksPresenterModule(new TasksPresenterModule(todoRepo, this))
                .build()
                .inject(this);
    }

    @Override
    public void bindData(List<TodoItem> todoItems) {
        mAdapter.setData(todoItems);
    }

    @Override
    public void showAddTask() {
        AddTaskActivity.start(this);
    }

    class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder> {

        List<TodoItem> todoItems;

        LayoutInflater mInflater;

        TodoListAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public TodoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TodoListViewHolder(mInflater.inflate(R.layout.adapter_todo_item, parent, false));
        }

        @Override
        public void onBindViewHolder(TodoListViewHolder holder, int position) {
            TodoItem todoItem = todoItems.get(position);
            holder.todoContent.setText(todoItem.content());
            holder.todoDate.setText(DateFormatUtil.getFormatDate(todoItem.ctime()));
        }

        @Override
        public int getItemCount() {
            return todoItems == null ? 0 : todoItems.size();
        }

        public void setData(List<TodoItem> todoItems) {
            this.todoItems = todoItems;
            notifyDataSetChanged();
        }

        class TodoListViewHolder extends RecyclerView.ViewHolder {

            TextView todoContent;
            TextView todoDate;

            public TodoListViewHolder(View itemView) {
                super(itemView);
                todoContent = (TextView) itemView.findViewById(R.id.todoContent);
                todoDate = (TextView) itemView.findViewById(R.id.todoDate);
            }
        }
    }
}
