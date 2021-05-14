package sg.edu.np.madpractical2_activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ListActivityAdapter extends RecyclerView.Adapter<ListActivityViewHolder> {
    ArrayList<User> listOfStudent;

    public ListActivityAdapter(ArrayList<User> input) { listOfStudent = input; }

    public ListActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.listactivityrecyclerview, parent, false);
        return new ListActivityViewHolder(item,listOfStudent);

    }

    public void onBindViewHolder(ListActivityViewHolder holder, int position){
        String thisStudentName = listOfStudent.get(position).name;
        holder.name.setText(thisStudentName);
        holder.description.setText(listOfStudent.get(position).getDescription());
        if(position % 2 == 0){
            holder.hankHolder.setImageResource(R.drawable.hank_happy);
        }
        if(thisStudentName.contains("7")){
            holder.sevenImage.setVisibility(View.VISIBLE);
            Log.v("CONTAINS7",thisStudentName+" contains 7");

        }
        else{
            Log.v("CONTAINS7",thisStudentName+" does not contain 7");
        }
    }

    public int getItemCount() {
        return listOfStudent.size();
    }

}
