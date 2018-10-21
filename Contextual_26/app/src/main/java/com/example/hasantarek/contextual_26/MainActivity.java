package com.example.hasantarek.contextual_26;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    ImageView imageView;
    ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.image_view);
        imageView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        if(actionMode != null)
                        {
                            return false;
                        }
                        else
                        {
                            actionMode = MainActivity.this.startActionMode(callback);
                            return true;
                        }
                        //return false;
                    }
                }
        );
    }


    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.my_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

            mode.setTitle("one item seleted");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if(item.getItemId()==R.id.delete)
            {
                Toast.makeText(MainActivity.this,"are you really want to delete",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
            else
            if(item.getItemId() == R.id.share)
            {
                Toast.makeText(MainActivity.this,"are you really want to share",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };

}
