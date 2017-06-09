package com.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<String> mData;
    BaseAdapter baseAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        baseAdapter = new BaseAdapter(this, mData);
        recyclerView.setAdapter(baseAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toobar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_HeaderView:
                addHeader(null);
                break;
            case R.id.add_FooterView:
                addFooter(null);
                break;
            case R.id.delete_FooterView:
                deleteFooter(null);
                break;
            case R.id.delete_HeaderView:
                deleteHeader(null);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            mData.add(String.format("这是第%d条数据啊，我真不知道", i));
        }
    }


    public void addHeader(View view) {
        View headView = LayoutInflater.from(this).inflate(R.layout.item_head, recyclerView, false);
        TextView textview = (TextView) headView.findViewById(R.id.head_tv);
        textview.setText(baseAdapter.getHeaderCount() + "Header");
        baseAdapter.addHeaderView(headView);
    }

    public void addFooter(View view) {

        View headView = LayoutInflater.from(this).inflate(R.layout.item_head, recyclerView, false);
        TextView textview = (TextView) headView.findViewById(R.id.head_tv);
        textview.setText(baseAdapter.getFooterCount() + "Footer");
        baseAdapter.addFooterView(headView);
    }

    public void deleteHeader(View view) {
        baseAdapter.deleteHeaderView();
    }

    public void deleteFooter(View view) {
        baseAdapter.deleteFooterView();
    }
}
