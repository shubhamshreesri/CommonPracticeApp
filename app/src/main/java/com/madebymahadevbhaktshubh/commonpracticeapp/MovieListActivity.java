package com.madebymahadevbhaktshubh.commonpracticeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.madebymahadevbhaktshubh.commonpracticeapp.adapters.MovieListAdapter;
import com.madebymahadevbhaktshubh.commonpracticeapp.models.MovieModel;
import com.madebymahadevbhaktshubh.commonpracticeapp.viewmodels.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity
{
    RecyclerView recview;
    List<MovieModel> movielist;
    MovieListViewModel listViewModel;
    MovieListAdapter adapter;
    TextView noresfound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recview=findViewById(R.id.recview);
        noresfound=findViewById(R.id.noresult);

        recview.setLayoutManager(new LinearLayoutManager(this));
        recview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        adapter=new MovieListAdapter(movielist);
        recview.setAdapter(adapter);

      //  listViewModel= ViewModelProviders.of(this).get(MovieListViewModel.class);
        listViewModel=new ViewModelProvider(this).get(MovieListViewModel.class);
        listViewModel.getMovielistObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels!=null) {
                    movielist= movieModels;
                    adapter.updatemovielist(movieModels);
                    noresfound.setVisibility(View.GONE);
                }
                if(movieModels==null)
                {
                    recview.setVisibility(View.GONE);
                    noresfound.setVisibility(View.VISIBLE);
                }
            }
        });
        listViewModel.makeApiCall();


    }
}