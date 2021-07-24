package com.team_noyeah.hankyung_adroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainSearchAdapterRecycleritem extends RecyclerView.Adapter<MainSearchAdapterRecycleritem.viewHolder>{
    private ArrayList<MainSearchRecycleritem> mData;

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView Recent;

        public viewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            Recent = itemView.findViewById(R.id.recentsearchitem);
        }
    }
    MainSearchAdapterRecycleritem(ArrayList<MainSearchRecycleritem> list){
        mData = list;
    }

    @Override
    public MainSearchAdapterRecycleritem.viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.fragment_recentsearch_recycleritem, parent, false) ;
        MainSearchAdapterRecycleritem.viewHolder vh = new MainSearchAdapterRecycleritem.viewHolder(view) ;

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewHolder holder, int position) {
        MainSearchRecycleritem recyclerItem = mData.get(position) ;
        holder.Recent.setText(recyclerItem.getRecentSearch()); ;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
