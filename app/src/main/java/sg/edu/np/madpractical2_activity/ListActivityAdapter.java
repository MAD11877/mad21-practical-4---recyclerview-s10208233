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
        holder.sevenImage.setVisibility(View.GONE);
        String thisStudentName = listOfStudent.get(position).name;
        holder.name.setText(thisStudentName);
        holder.description.setText(listOfStudent.get(position).getDescription());
        if(position % 2 == 0){
            holder.hankHolder.setImageResource(R.drawable.hank_happy);
        }
        String lastDigit = thisStudentName.substring(thisStudentName.length() - 1);
        if (lastDigit.contains("7")) {
            holder.sevenImage.setVisibility(View.VISIBLE);
        }
    }

    public int getItemCount() {
        return listOfStudent.size();
    }

}
