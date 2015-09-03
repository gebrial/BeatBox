package com.bignerdranch.android.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjaya on 03/09/15.
 */
public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context){
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds(){
        String[] soundsNames;
        try{
            soundsNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + soundsNames.length + " sounds.");
        } catch (IOException e) {
            Log.e(TAG, "Could not list assets", e);
            return;
        }

        for (String filename : soundsNames){
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
