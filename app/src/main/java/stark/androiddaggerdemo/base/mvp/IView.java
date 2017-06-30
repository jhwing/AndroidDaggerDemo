package stark.androiddaggerdemo.base.mvp;

import android.content.Context;

/**
 * Created by jihongwen on 2017/6/28.
 */

public interface IView {

    Context getViewContext();

    void onFinish();
}
