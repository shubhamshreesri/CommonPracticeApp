package com.madebymahadevbhaktshubh.commonpracticeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.madebymahadevbhaktshubh.commonpracticeapp.R;
import com.madebymahadevbhaktshubh.commonpracticeapp.models.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.myviewholder>
{
    List<MovieModel> movielist;

    public MovieListAdapter(List<MovieModel> list) {
        this.movielist = list;
    }

    public void updatemovielist(List<MovieModel> list) {
        this.movielist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
      holder.title.setText(movielist.get(position).getName());
   //   Glide.with(holder.title.getContext()).load("http://192.168.0.100/api/images/"+movielist.get(position).getImage()).into(holder.img);
      Glide.with(holder.title.getContext()).load("http://192.168.29.161/MdJamalprj/api/images/"+movielist.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        if(this.movielist!=null)
         return this.movielist.size();
        else
            return 0;
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView img;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleView);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}
