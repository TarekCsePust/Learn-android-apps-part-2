package com.example.hasantarek.tabletsupport_43;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements HeadlineFragment.onHeadlineClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void headlineselect(String headline) {
          ArticleFragment articleFragment = (ArticleFragment)getFragmentManager().findFragmentById(R.id.article_frag);
          if(articleFragment == null)
          {
              Intent intent = new Intent(this,ArticleActivity.class);
              intent.putExtra("headline",headline);
              startActivity(intent);
          }
          else {
              articleFragment.updateinfo(headline);
          }
    }
}
