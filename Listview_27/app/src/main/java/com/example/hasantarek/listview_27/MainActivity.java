package com.example.hasantarek.listview_27;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView listView;
    String languages[]={
      "C","C++","Python","Java","Php","C#"
    };
    ArrayList<String>arrayList = new ArrayList<String>();
    ArrayAdapter<String>adapter;
    List selection = new ArrayList();
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_item);
        for(String language:languages)
        {
            arrayList.add(language);
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                if(checked)
                {
                    selection.add(arrayList.get(position));
                    count++;
                    mode.setTitle(count+"item selected");
                }
                else
                {
                    if(selection.contains(arrayList.get(position))) {
                        selection.remove(arrayList.remove(position));
                        count--;
                        mode.setTitle(count + "item selected");
                    }
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.my_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if(item.getItemId()==R.id.delete)
                {
                    for(Object Item:selection)
                    {
                        String lang = Item.toString();
                        arrayList.remove(lang);

                    }
                    adapter.notifyDataSetChanged();
                    mode.finish();
                    return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

                count=0;
                selection.clear();
            }
        });
    }




}
