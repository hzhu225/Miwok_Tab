package com.example.android.miwok;

public class Word
{
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;

    public Word(String defaultTrans, String miworkTrans)
    {
        mDefaultTranslation = defaultTrans;
        mMiwokTranslation = miworkTrans;
    }

    public Word(String defaultTrans, String miworkTrans, int imageResourceId)
    {
        mDefaultTranslation = defaultTrans;
        mMiwokTranslation = miworkTrans;
        mImageResourceId = imageResourceId;
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
}
