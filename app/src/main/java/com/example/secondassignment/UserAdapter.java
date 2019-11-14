package com.example.secondassignment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondassignment.Modal.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.userHolder> {

    List<User> users = new ArrayList<>();
    private Context context;
    private OnUserClickListener onUserClickListener;

    public UserAdapter(List<User> users, Context context, OnUserClickListener onUserClickListener) {
        this.users = users;
        this.context = context;
        this.onUserClickListener = onUserClickListener;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout, parent, false);
        userHolder userHolder = new userHolder(view, onUserClickListener);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {
        final User user = users.get(position);
        holder.tvName.setText(user.getName());
        holder.imageView.setImageResource(user.getImg());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class userHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView tvName;
        OnUserClickListener onUserClickListener;

        public userHolder(@NonNull View itemView, OnUserClickListener onUserClickListener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.userImg);
            tvName = itemView.findViewById(R.id.userName);

            this.onUserClickListener = onUserClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onUserClickListener.onUserClickListener(getAdapterPosition());
        }
    }

    public interface OnUserClickListener{
        void onUserClickListener(int position);
    }

}
