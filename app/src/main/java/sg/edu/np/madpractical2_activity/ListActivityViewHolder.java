package sg.edu.np.madpractical2_activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;


public class ListActivityViewHolder extends RecyclerView.ViewHolder{
    TextView name,description;
    ImageView hankHolder;
    ArrayList<User> listOfUsers;
    ImageView sevenImage;
    public ListActivityViewHolder(View itemView, ArrayList<User> passedList){
        super(itemView);
        sevenImage = itemView.findViewById(R.id.imageseven);
        name = itemView.findViewById(R.id.laRname);
        description = itemView.findViewById(R.id.laRdesc);
        hankHolder = itemView.findViewById(R.id.hankHolder);
        listOfUsers = passedList;
//        itemView.setOnClickListener(this);

    }

//    @Override
//    public void onClick(final View view) {
//        fart();
//        Log.v("PLEASE", String.valueOf(getAbsoluteAdapterPosition()));
//        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
//                builder.setTitle("Profile");
//                builder.setMessage(listOfUsers.get(getAbsoluteAdapterPosition()).name);
//                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Log.v("stupidViewTest",view.getRootView().toString());
//                        fart();
//                        Intent intent = new Intent(itemView.getContext(), MainActivity.class);
//                        intent.putExtra("userObj", listOfUsers.get(getAbsoluteAdapterPosition()));
////                        Bundle sendToMain = new Bundle();
////                        sendToMain.putString("name",listOfUsers.get(getAbsoluteAdapterPosition()).name);
////                        sendToMain.putString("desc",listOfUsers.get(getAbsoluteAdapterPosition()).description);
////                        sendToMain.putInt("id",listOfUsers.get(getAbsoluteAdapterPosition()).id);
////                        sendToMain.putBoolean("followStatus",listOfUsers.get(getAbsoluteAdapterPosition()).followed);
////                        intent.putExtras(sendToMain);
//                        itemView.getContext().startActivity(intent);
//                }
//                });
//                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        fart();
//                    }
//                });
//                AlertDialog createdDialog = builder.create();
//                createdDialog.show();
//    }
//
//    public void fart(){
//        MediaPlayer media = MediaPlayer.create(itemView.getContext(), R.raw.fart);
//        media.start();
//        if(!media.isPlaying())
//            media.release();
//    }
}
