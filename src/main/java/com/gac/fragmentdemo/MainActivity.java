package com.gac.fragmentdemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements TextFragment.OnTextClickListener{

    private Button bt;
    private View container;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button)findViewById(R.id.id_bt);
        container = findViewById(R.id.id_fragment_container);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    flag = false;
                    addFragmentOne();
                }else{
                    flag = true;
                    addFragmentTwo();
                }

            }
        });
    }

    //动态添加Fragment
    public void addFragment(){
         OneFragment fragment = new OneFragment();
        getSupportFragmentManager().beginTransaction()
            .add(R.id.id_fragment_container, fragment).commit();
    }
    public void addFragmentOne(){
        if(container != null){
            OneFragment fragment = new OneFragment();
            Bundle bundle = new Bundle();
            bundle.putString("text","this is bundle for one fragment");

            fragment.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


            transaction.replace(R.id.id_fragment_container, fragment);
            transaction.addToBackStack(null);


            transaction.commit();
        }
    }

    private void addFragmentTwo(){
        if(container != null){
            TwoFragment fragment = new TwoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("text", "this is bundle for two fragment");

            fragment.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


            transaction.replace(R.id.id_fragment_container, fragment);
            transaction.addToBackStack(null);
           // getSupportFragmentManager().beginTransaction()
                //    .add(R.id.id_fragment_container, fragment).commit();
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void textClick(String str) {
        OneFragment fragment = (OneFragment)
                getSupportFragmentManager().findFragmentById(R.id.id_one);

        fragment.print(str);
        /*
        *
        *  //对于一个container 两个fragment切换的情况 传递数据的方法
        //就是切换fragment new出需要数据的fragment 将传递的数据作为参数 加入new出的fragment 调用切换frament 方法代码如下

        TwoFragment newFragment = new TwoFragment();
        Bundle args = new Bundle();
        args.putString("data", str);
        newFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        transaction.replace(R.id.id_fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
        *
        *
        *
        *
        * */

    }
}
