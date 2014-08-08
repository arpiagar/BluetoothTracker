package com.example.tejasvees.fk_mob_hack_test_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.media.SoundPool;
import com.example.tejasvees.fk_mob_hack_test_1.R;

public class MyActivity5 extends Activity {
    private SoundPool sp;
    private Integer soundID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity5);
        soundID=loadFile("/Users/arpit.agarwal/Downloads/Fk_Mob_Hack_Test_1/app/src/main/res/Air_alert.mp3");
        playSound(soundID,8,8,1,0,1);
        unloadSound(soundID);
    }

    public int loadFile(String filepath){
        sp=new SoundPool(2,3,0);
        soundID=sp.load(filepath,1);
        return soundID;
    }
    public void playSound(int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate){
          sp.play( soundID,  leftVolume,  rightVolume,  priority,  loop,  rate);
    }

    public boolean unloadSound(int soundID){
        return unloadSound(soundID);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
