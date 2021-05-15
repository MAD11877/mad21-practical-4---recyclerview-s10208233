package sg.edu.np.madpractical2_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static sg.edu.np.madpractical2_activity.ListActivity.staticList;

public class MainActivity extends AppCompatActivity{
    private final static String TAG =  "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"Create!");

        final Button followButton = findViewById(R.id.followbtn);
        Button msg = findViewById(R.id.messagebtn);
        TextView nameHolder = findViewById(R.id.nameHolder);
        TextView descHolder = findViewById(R.id.descHolder);
        final ImageView imageHolder = findViewById(R.id.imageholder);

        final Intent receivingEnd = getIntent();
        final User userObj = staticList.get(receivingEnd.getIntExtra("position",21));

        nameHolder.setText(userObj.name);
        descHolder.setText(userObj.description);
        if(userObj.followed == true){followButton.setText("unfollow");imageHolder.setImageResource(R.drawable.hank_happy);}
        else{followButton.setText("follow");imageHolder.setImageResource(R.drawable.hank_depressed);}

        followButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                if(userObj.followed == false){
                    followButton.setText("unfollow");
                    userObj.setFollowed(true);
                    imageHolder.setImageResource(R.drawable.hank_happy);
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }
                else{
                    followButton.setText("follow");
                    userObj.setFollowed(false);
                    imageHolder.setImageResource(R.drawable.hank_depressed);
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }
                fart();
            }
        });
        msg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fart();
                Intent intent = new Intent(MainActivity.this, stupidVideo.class);
                startActivity(intent);
            }
        });


    }

    public void fart(){
        MediaPlayer media = MediaPlayer.create(MainActivity.this, R.raw.fart);
        media.start();
        if(!media.isPlaying())
            media.release();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG,"Start!");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG,"Resume!");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG,"Pause!");
        finish();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG,"Stop!");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"Stop!");
    }
}