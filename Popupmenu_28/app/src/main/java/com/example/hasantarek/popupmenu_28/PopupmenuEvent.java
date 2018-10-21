package com.example.hasantarek.popupmenu_28;

import android.content.Context;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by Hasan Tarek on 7/13/2017.
 */
public class PopupmenuEvent implements PopupMenu.OnMenuItemClickListener {

    Context context;
    public PopupmenuEvent(Context context)
    {
        this.context = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if(item.getItemId() == R.id.admin)
        {
            Toast.makeText(
                    context,"admin selected",Toast.LENGTH_SHORT
            ).show();
            return true;
        }
        else
        if(item.getItemId() == R.id.user)
        {
            Toast.makeText(context,"user selected",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
