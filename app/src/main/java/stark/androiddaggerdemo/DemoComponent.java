package stark.androiddaggerdemo;

import dagger.Component;

/**
 * Created by jihongwen on 2017/6/22.
 */

@Component(modules = TestModule.class)
public interface DemoComponent {

    TestA getA();

    void inject(MainActivity mainActivity);
}
