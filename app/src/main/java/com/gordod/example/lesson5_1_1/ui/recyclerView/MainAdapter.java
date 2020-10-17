package com.gordod.example.lesson5_1_1.ui.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gordod.example.lesson5_1_1.R;
import com.gordod.example.lesson5_1_1.data.model.FilmModel;
import com.gordod.example.lesson5_1_1.ui.main.MainActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolderMain> {
    List<FilmModel> filmList;
    BookOnClick bookOnClick;
    MainActivity activity;

    public MainAdapter(List<FilmModel> filmList, BookOnClick bookOnClick, MainActivity activity) {
        this.filmList = filmList;
        this.bookOnClick = bookOnClick;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolderMain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderMain(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMain holder, int position) {
        holder.text.setText(filmList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    protected class ViewHolderMain extends RecyclerView.ViewHolder {
        TextView text;
        public ViewHolderMain(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.view_holder_textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bookOnClick.filmOnClick(getAdapterPosition());
                }
            });
        }
    }
}
