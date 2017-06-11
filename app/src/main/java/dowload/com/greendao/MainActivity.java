package dowload.com.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import dowload.com.greendao.gen.UserBeanDao;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    UserBeanDao userBeanDao;
    ListView listView;

    List<UserBean> userBeans;
    ListAdapter listAdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.user_tv);
        listView = (ListView) findViewById(R.id.listView);
        userBeanDao = MyApplication.daoSession.getUserBeanDao();
    }

    /**
     * 插入数据
     * @param view
     */
    public void onInsert(View view) {
        UserBean userBean = new UserBean(null, "15888888888", "0000", "今日头条", false, System.currentTimeMillis() + "", "贝塔俺的嘎马");
        userBeanDao.insert(userBean);
    }

    /**
     * 查找
     * @param view
     */
    public void onFind(View view) {
        userBeans = MyApplication.daoSession.getUserBeanDao().loadAll();
        if (userBeans != null&&userBeans.size()>0) {
            if (listAdater == null) {
                listAdater = new ListAdapter(userBeans);
                listView.setAdapter(listAdater);
            } else {
                listAdater.setNewData(userBeans);
            }
        }else{
            Toast.makeText(this, "数据库没有数据啦，插入一条吧", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 更新某条数据
     */
    public void onUpdate(View view) {
        if (userBeans != null) {
            UserBean userBean = userBeans.get(0);
            userBean.setUserName("贝塔俺的嘎马更新后的数据");
            userBeanDao.update(userBean);
        } else {
            Toast.makeText(this, "请先查询", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 删除第一条数据
     * @param view
     */
    public void onDelete(View view) {
        if (userBeans != null) {
            userBeanDao.delete(userBeans.get(0));
        } else {
            Toast.makeText(this, "请先查询", Toast.LENGTH_SHORT).show();
        }
    }

    class ListAdapter extends BaseAdapter {
        List<UserBean> mData;

        public ListAdapter(List<UserBean> mData) {
            this.mData = mData;
        }

        @Override
        public int getCount() {
            return mData != null ? mData.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_listview, parent, false);
            TextView textView = (TextView) view.findViewById(R.id.item_tv);
            textView.setText(mData.get(position).getId() + "===" + mData.get(position).getUserName());
            return view;
        }

        public void setNewData(List<UserBean> newData) {
            this.mData = newData;
            notifyDataSetChanged();
        }
    }
}
