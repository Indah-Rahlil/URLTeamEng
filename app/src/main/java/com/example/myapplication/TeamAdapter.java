package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder>{
    private List<Team> teamList;
    private Context context;

    public TeamAdapter(List<Team> teamList, Context context) {
        this.teamList = teamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.teamName.setText(team.getStrTeam());
        Glide.with(context).load(team.getStrTeamBadge()).into(holder.teamBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamName;
        ImageView teamBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.nama_team);
            teamBadge = itemView.findViewById(R.id.image_team);
        }
    }
}
