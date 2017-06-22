package stark.androiddaggerdemo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jihongwen on 2017/6/22.
 */

@Module
public class TestModule {

    @Provides
    public TestB provideTestB() {
        return new TestB();
    }
}
