package sg.edu.np.madpractical2_activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG =  "FINDTHIS ";
    static ArrayList<User> staticList;
    ListActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> listOfUsers = new ArrayList<>();

        //  CREATE DATA FOR REVIEW
        for (int i = 1; i <= 20; i++){
            listOfUsers.add(new User("Name"+randomInt(9999), String.valueOf(randomInt(9999)),i,randomTF()));
        }
        staticList = listOfUsers;
        Log.v(TAG,listOfUsers.toString());

        //  SET RECYCLERVIEW
        RecyclerView recyclerView = findViewById(R.id.laRview);
        ListActivityAdapter laAdapter = new ListActivityAdapter(staticList);
        LinearLayoutManager laLayoutmanager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(laLayoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(laAdapter);

        adapter = laAdapter;



//        ImageView androidface = findViewById(R.id.androidface);

//        androidface.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
//                builder.setTitle("Profile");
//                builder.setMessage("MADness?");
//                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent intent = new Intent(ListActivity.this, MainActivity.class);
//                        intent.putExtra("randomNumber", randomInt(9999));
//                        startActivity(intent);
//
//                    }
//                });
//                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                AlertDialog createdDialog = builder.create();
//                createdDialog.show();
//            }
//        });
    }

    private int randomInt(int range){
        Random rand = new Random();
        int randomNumber = rand.nextInt(range);
        return randomNumber;
    }

    private boolean randomTF(){
        Random random = new Random();
        return random.nextBoolean();
    }

        @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG,"Resume!");
        adapter.notifyDataSetChanged();
    }

}