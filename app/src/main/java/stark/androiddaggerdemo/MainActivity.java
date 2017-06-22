package stark.androiddaggerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    TestA testA;

    @Inject
    TestB testB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerDemoComponent.builder()
                .testModule(new TestModule())
                .build()
                .inject(this);
    }

    public void testAClick(View view) {
        //TestA testA = DaggerDemoComponent.create().getA();
        testA.show(this);
    }

    public void testBClick(View view) {
        testB.show(this);
    }
}
