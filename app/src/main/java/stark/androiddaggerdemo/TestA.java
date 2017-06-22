package stark.androiddaggerdemo;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * Created by jihongwen on 2017/6/22.
 */

public class TestA {

    @Inject
    public TestA() {

    }

    public void show(Context context) {
        Toast.makeText(context, "this is testA", Toast.LENGTH_SHORT).show();
    }
}
