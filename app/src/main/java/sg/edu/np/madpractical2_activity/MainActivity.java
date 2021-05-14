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

public class MainActivity extends AppCompatActivity {
    private final static String TAG =  "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"Create!");

        Intent receivingEnd = getIntent();
        String name = receivingEnd.getStringExtra("name");
        String desc = receivingEnd.getStringExtra("desc");
        int id = receivingEnd.getIntExtra("id", 0);
        boolean followStatus = receivingEnd.getBooleanExtra("followStatus",false);
        final User userObj = new User(name,desc,id,followStatus);


        final Button followbtn = findViewById(R.id.followbtn);
        Button msg = findViewById(R.id.messagebtn);
        TextView nameHolder = findViewById(R.id.nameHolder);
        TextView descHolder = findViewById(R.id.descHolder);
        final ImageView imageHolder = findViewById(R.id.imageholder);

        nameHolder.setText(userObj.name);
        descHolder.setText(userObj.description);


        followbtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                if(userObj.followed == false){
                    followbtn.setText("unfollow");
                    userObj.setFollowed(true);
                    imageHolder.setImageResource(R.drawable.hank_depressed);
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }
                else{
                    followbtn.setText("follow");
                    userObj.setFollowed(false);
                    imageHolder.setImageResource(R.drawable.hank_happy);
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }
                fart();
                Log.v(TAG, userObj.getName()+userObj.getId()+userObj.followed);
            }
        });



        Button button = findViewById(R.id.messagebtn);
        button.setOnClickListener(new View.OnClickListener(){
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
//    @Override
//    protected void onStart(){
//        super.onStart();
//        Log.v(TAG,"Start!");
//    }
//    @Override
//    protected void onResume(){
//        super.onResume();
//        Log.v(TAG,"Resume!");
//    }
//    @Override
//    protected void onPause(){
//        super.onPause();
//        Log.v(TAG,"Pause!");
//    }
//    @Override
//    protected void onStop(){
//        super.onStop();
//        Log.v(TAG,"Stop!");
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.v(TAG,"Stop!");
//    }
}