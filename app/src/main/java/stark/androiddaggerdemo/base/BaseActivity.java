package stark.androiddaggerdemo.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import stark.androiddaggerdemo.base.mvp.IView;

/**
 * Created by jihongwen on 2017/6/28.
 */

public abstract class BaseActivity extends AppCompatActivity implements IView {

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void onFinish() {
        finish();
    }
}
