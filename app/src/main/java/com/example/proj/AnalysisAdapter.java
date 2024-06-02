package com.example.proj;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnalysisAdapter  extends RecyclerView.Adapter<AnalysisAdapter.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView avatar;


        public ViewHolder(@NonNull View itemView){
            super(itemView);

            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
        }

        public void setAvatar(int resource){
            this.avatar.setImageResource(resource);
        }

        public void setFio(String name){
            this.name.setText(name);
        }
    }

    private ArrayList<Analysis> analyz;
    private LayoutInflater inflater;

    public AnalysisAdapter(Context context, ArrayList<Analysis> analyz){
            this.analyz = analyz;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AnalysisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.analysis_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnalysisAdapter.ViewHolder holder, int position) {
        Analysis item = analyz.get(position);


        holder.setFio(item.getName());
        holder.setAvatar(item.getImageResourse());
        int pos = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), GenderActivity.class);
                i.putExtra("blur", pos);
                view.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return analyz.size();
    }

}
