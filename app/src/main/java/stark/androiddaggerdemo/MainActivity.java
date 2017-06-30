package stark.androiddaggerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import stark.androiddaggerdemo.module.tasks.TasksActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, TasksActivity.class));
    }

    public void testAClick(View view) {
    }

    public void testBClick(View view) {
    }
}
