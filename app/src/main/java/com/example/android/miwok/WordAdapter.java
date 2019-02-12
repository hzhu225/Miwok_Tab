package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>
{
    public WordAdapter(Context context, ArrayList<Word> resource)
    {
        super(context,0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);
        TextView defaultTV = (TextView)listItemView.findViewById(R.id.default_text_view);
        defaultTV.setText(currentWord.getDefaultTranslation());
        TextView miwokTV = (TextView)listItemView.findViewById(R.id.miwok_text_view);
        miwokTV.setText(currentWord.getMiwokTranslation());
        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image);
        if(currentWord.getImageResourceId() == -1)                  //no ImageResourceId
        {
            imageView.setVisibility(View.GONE);
        }
        else
        {
             imageView.setImageResource(currentWord.getImageResourceId());
        }

        return listItemView;
    }
}
