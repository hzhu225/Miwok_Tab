package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment
{
    private MediaPlayer player;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener()
    {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer)
        {
            releaseMediaPlayer();
        }
    };
    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
        @Override
        public void onAudioFocusChange(int focusChange)
        {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                player.pause();
                player.seekTo(0);       //reverse player to beginning
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN)
            {
                player.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS)
            {
                releaseMediaPlayer();
            }
        }
    };


    public ColorsFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red,  R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green,  R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown,  R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray,  R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black,  R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white,  R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,  R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,  R.raw.color_mustard_yellow));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), words,R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.word_listView);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Word word = words.get(position);
                releaseMediaPlayer();
                //Request audio focus
                int result = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)     //if we get audio focus now
                {
                    player = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    player.start();
                    player.setOnCompletionListener(completionListener);
                }
            }
        });
        return rootView;
    }


    @Override
    public void onStop()
    {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(player!= null)
        {
            player.release();
            player = null;
        }
        audioManager.abandonAudioFocus(audioFocusChangeListener);
    }

}
