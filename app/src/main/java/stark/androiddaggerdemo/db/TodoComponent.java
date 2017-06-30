package stark.androiddaggerdemo.db;

import javax.inject.Singleton;

import dagger.Component;
import stark.androiddaggerdemo.TodoModule;

/**
 * Created by jihongwen on 2017/6/30.
 */

@Singleton
@Component(modules = {TodoModule.class, TodoDBModule.class})
public interface TodoComponent {

    TodoRepo getTodoRepo();
}
