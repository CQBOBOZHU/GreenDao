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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dowload.com.greendao.gen.MaBeanDao;
import dowload.com.greendao.gen.ManBeanDao;
import dowload.com.greendao.gen.WomenBeanDao;

public class Main3Activity extends AppCompatActivity {
    ManBeanDao manBeanDao;
    WomenBeanDao womenBeanDao;
    ListView listView;
    ListAdapter listAdapter;
    MaBeanDao maBeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        manBeanDao = MyApplication.daoSession.getManBeanDao();
        womenBeanDao = MyApplication.daoSession.getWomenBeanDao();
        maBeanDao = MyApplication.daoSession.getMaBeanDao();
        listView = (ListView) findViewById(R.id.listView);
        listAdapter = new ListAdapter(new ArrayList<WomenBean>());
        listView.setAdapter(listAdapter);
    }

    ManBean manBean;

    int i = 0;

    public void onAddTeacher(View view) {
        manBean = new ManBean();
        manBean.setId((long) (i++));
        manBean.setName("王尼玛");
        manBean.setAge("25");
        manBean.setMId((long) (i * 100));
        manBeanDao.insertOrReplaceInTx(manBean);
    }

    public void onAddStudent(View view) {
        Random random = new Random();
        int max = random.nextInt(10);
        for (int i = 0; i < max; i++) {
            WomenBean womenBean = new WomenBean();
            womenBean.setId(null);
            womenBean.setAge("200" + i + "===" + manBean.getId());
            womenBean.setName("亡灵" + i);
            womenBean.setWId(manBean.getId());
            womenBeanDao.insert(womenBean);
        }

    }

    public void onFindTeacher(View view) {
    }

    int b = 0;

    public void onFindStudent(View view) {
        List<WomenBean> womenBeens;
        if (b % 2 == 0) {
            womenBeens = womenBeanDao.loadAll();
            listAdapter.setNewData(womenBeens);
        } else {
            womenBeens = manBeanDao.load((long) 5).getWomenBeanList();
        }
        listAdapter.setNewData(womenBeens);
        b++;
    }

    public void onAddMa(View view) {
        if (manBean != null) {
            MaBean maBean = new MaBean();
            maBean.setId(null);
            maBean.setName("wo shi ni mama");
            maBean.setAge(50);
            maBean.setMId(manBean.getMId());
            maBeanDao.insertOrReplaceInTx(maBean);
        }
    }

    public void onFindMa(View view) {
        MaBean maBean = manBeanDao.load(manBean.getId()).getMaBean();
        if (maBean != null) {
            Toast.makeText(this, maBean.getName(), Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
    }


    class ListAdapter extends BaseAdapter {
        List<WomenBean> mData;

        public ListAdapter(List<WomenBean> mData) {
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
            View view = LayoutInflater.from(Main3Activity.this).inflate(R.layout.item_listview, parent, false);
            TextView textView = (TextView) view.findViewById(R.id.item_tv);
            textView.setText(mData.get(position).getId() + "=====" + mData.get(position).getAge());
            return view;
        }

        public void setNewData(List<WomenBean> newData) {
            this.mData = newData;
            notifyDataSetChanged();
        }
    }
}
