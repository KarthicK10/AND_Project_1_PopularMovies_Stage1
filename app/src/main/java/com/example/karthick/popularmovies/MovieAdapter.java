package com.example.karthick.popularmovies;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.karthick.popularmovies.domain.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by KarthicK on 6/6/2016.
 */
public class MovieAdapter extends ArrayAdapter<Movie> {
    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();

    public MovieAdapter(Activity context, List<Movie> moviesList){
        super(context, 0, moviesList);
    }

    /**
     * {@inheritDoc}
     *
     * @param position
     * @param convertView
     * @param parent
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*Recycle old view if possible, if not create a new view */
        View rootView;
        if(convertView != null){
            rootView = convertView;
        }
        else{
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_movie, parent, false);
        }

        Movie movie = getItem(position);
        String posterPath = movie.getPosterPath();
        final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/";
        String imageSizePath = "w500/";

        /*Load the image view by fetching image from picasso using the movie's poster path */
        ImageView poseterImageView = (ImageView)rootView.findViewById(R.id.grid_item_movie_poster_imageView);
        String picassoPath = IMAGE_BASE_URL+imageSizePath+movie.getPosterPath();
        Picasso.with(getContext()).load(picassoPath).into(poseterImageView);

        return rootView;
    }
}
