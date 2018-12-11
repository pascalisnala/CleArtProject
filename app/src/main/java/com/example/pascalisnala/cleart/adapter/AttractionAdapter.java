package com.example.pascalisnala.cleart.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pascalisnala.cleart.Activities.DetailActivity;
import com.example.pascalisnala.cleart.models.Attraction;
import com.example.pascalisnala.cleart.R;
import com.example.pascalisnala.cleart.models.HomeResponse;

import java.util.List;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {
    private Context mCtx;
    private List<Attraction> attrList;

    public AttractionAdapter(Context mCtx,List<Attraction> attrList) {
        this.mCtx = mCtx;
        this.attrList = attrList;
    }

    @NonNull
    @Override
    public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.home_view, parent, false);
        return new AttractionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, int position) {
        final Attraction attraction = attrList.get(position);

        holder.tvAttrName.setText(attraction.getAttrname());
        holder.tvAttrLoc.setText(attraction.getLocation());
        holder.tvAttrClk.setText(attraction.getSchedule());

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mCtx, attraction.getAttrname(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mCtx, DetailActivity.class);
                intent.putExtra("attrname",attraction.getAttrname());
                intent.putExtra("attrdesc",attraction.getDetails());
                intent.putExtra("attrloc", attraction.getLocation());
                intent.putExtra("attrschedule",attraction.getSchedule());
                mCtx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return attrList.size();
    }

    class AttractionViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhotos;
        TextView tvAttrName, tvAttrLoc, tvAttrClk, tvAttrRate;
        ConstraintLayout parent_layout;

        public AttractionViewHolder(View itemView) {
            super(itemView);

            imgPhotos = itemView.findViewById(R.id.imgPhotos);
            tvAttrName = itemView.findViewById(R.id.tvAttrName);
            tvAttrLoc = itemView.findViewById(R.id.tvAttrLoc);
            tvAttrClk = itemView.findViewById(R.id.tvAttrClk);
            tvAttrRate = itemView.findViewById(R.id.tvAttrRate);

            parent_layout = itemView.findViewById(R.id.parent_layout);



        }
    }
}
