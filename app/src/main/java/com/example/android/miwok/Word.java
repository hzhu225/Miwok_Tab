package com.example.android.miwok;

public class Word
{
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word(String defaultTrans, String miworkTrans)
    {
        mDefaultTranslation = defaultTrans;
        mMiwokTranslation = miworkTrans;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

}
