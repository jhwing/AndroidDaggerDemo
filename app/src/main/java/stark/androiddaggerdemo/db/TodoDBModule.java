package stark.androiddaggerdemo.db;

import android.app.Application;
import android.content.Context;

import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jihongwen on 2017/6/28.
 */

@Module
public class TodoDBModule {

    @Provides
    TodoDBHelper provideDBHelper(Application context) {
        return new TodoDBHelper(context);
    }

    @Provides
    SqlBrite provideSqlBrite() {
        return new SqlBrite.Builder().build();
    }

    @Provides
    BriteDatabase provideBriteDatabase(TodoDBHelper todoDBHelper, SqlBrite sqlBrite) {
        return sqlBrite.wrapDatabaseHelper(todoDBHelper, Schedulers.io());
    }

    @Provides
    @Singleton
    TodoRepo provideTodoRepo(BriteDatabase briteDatabase) {
        return new TodoRepo(briteDatabase);
    }
}
