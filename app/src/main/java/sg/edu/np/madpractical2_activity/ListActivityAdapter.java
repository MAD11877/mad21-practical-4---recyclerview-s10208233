package sg.edu.np.madpractical2_activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import static sg.edu.np.madpractical2_activity.ListActivity.staticList;

public class ListActivityAdapter extends RecyclerView.Adapter<ListActivityViewHolder>{

    public ListActivityAdapter(ArrayList<User> input) { staticList = input; }

    public ListActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.listactivityrecyclerview, parent, false);
        return new ListActivityViewHolder(item,staticList);

    }

    public void onBindViewHolder(ListActivityViewHolder holder, final int position){
        final User bindedUser = staticList.get(position);
        final String name = bindedUser.name;
        String desc = bindedUser.description;
        int id = bindedUser.id;
        boolean followStatus = bindedUser.followed;

        //  For when last digit in name is "7"
        holder.sevenImage.setVisibility(View.GONE);
        holder.name.setText(name);
        holder.description.setText(desc);

        if(followStatus==false){
            holder.hankHolder.setImageResource(R.drawable.hank_depressed);
        }

        //  Practical 4 Q4
        String lastDigit = name.substring(name.length() - 1);
        if (lastDigit.contains("7")) {
            holder.sevenImage.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                fart(view);
                Log.v("PLEASE", String.valueOf(position));
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Profile");
                builder.setMessage(name);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.v("stupidViewTest",view.getRootView().toString());
                        fart(view);
                        Intent intent = new Intent(view.getContext(), MainActivity.class);
//                        intent.putExtra("userObj", bindedUser);
                        intent.putExtra("position",position);
                        view.getContext().startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        fart(view);
                    }
                });
                AlertDialog createdDialog = builder.create();
                createdDialog.show();
            }
        });
    }

    public void fart(View v){
        MediaPlayer media = MediaPlayer.create(v.getContext(), R.raw.fart);
        media.start();
        if(!media.isPlaying())
            media.release();
    }

    public int getItemCount() {
        return staticList.size();
    }

}
