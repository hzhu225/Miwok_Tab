package com.example.android.miwok;

public class Word
{
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioResourceId;

    public Word(String defaultTrans, String miworkTrans, int audioResourceId)
    {
        mDefaultTranslation = defaultTrans;
        mMiwokTranslation = miworkTrans;
        mImageResourceId = -1;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTrans, String miworkTrans, int imageResourceId, int audioResourceId)
    {
        mDefaultTranslation = defaultTrans;
        mMiwokTranslation = miworkTrans;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getImageResourceId()
    {
        return mImageResourceId;
    }

    public int getAudioResourceId()
    {
        return mAudioResourceId;
    }
}
