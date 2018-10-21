package com.example.hasantarek.tabletsupport_43;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hasan Tarek on 7/16/2017.
 */
public class ArticleFragment extends Fragment {
    TextView head_text,news_text;
    String article[];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article,container,false);
        head_text = (TextView)view.findViewById(R.id.heading_text_id);
        news_text = (TextView)view.findViewById(R.id.desc_id);

        return view;
    }

    public void updateinfo(String headline)
    {
        article = getResources().getStringArray(R.array.news_contents);
        if(headline.equals("Headline 1"))
        {
            head_text.setText("News Headline 1");
            news_text.setText(article[0]);
        }
        else
        if(headline.equals("Headline 2"))
        {
            head_text.setText("News Headline 2");
            news_text.setText(article[0]);
        }
        else
        if(headline.equals("Headline 3"))
        {
            head_text.setText("News Headline 3");
            news_text.setText(article[0]);
        }
        else
        if(headline.equals("Headline 4"))
        {
            head_text.setText("News Headline 4");
            news_text.setText(article[0]);
        }
        else
        if(headline.equals("Headline 5"))
        {
            head_text.setText("News Headline 5");
            news_text.setText(article[0]);
        }
        else
        if(headline.equals("Headline 6"))
        {
            head_text.setText("News Headline 6");
            news_text.setText(article[0]);
        }

    }
}
