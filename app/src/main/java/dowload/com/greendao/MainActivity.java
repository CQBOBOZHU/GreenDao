package dowload.com.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.user_tv);
    }

    public void onInsert(View view) {
        UserBean userBean = new UserBean(1, "15803006150", "0000", "什么鬼东西", false, System.currentTimeMillis() + "");
        MyApplication.daoSession.getUserBeanDao().insert(userBean);
    }

    public void onFind(View view) {
        List<UserBean> userBean = MyApplication.daoSession.getUserBeanDao().loadAll();
        if (userBean != null)
            textView.setText(userBean.size() + "===" + userBean.get(0).toString());
    }
}
