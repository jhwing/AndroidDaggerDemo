package stark.androiddaggerdemo;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jihongwen on 2017/6/29.
 */

@Module
public class TodoModule {

    Application mApplication;

    public TodoModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }
}
