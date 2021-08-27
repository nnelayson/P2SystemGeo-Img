package com.jose.p2system.HomeAdapter2;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jose.p2system.DelroActivity;
import com.jose.p2system.HomeAdapter2.FeaturedHelperClass2;
import com.jose.p2system.R;

import java.util.ArrayList;

public class FeaturedAdapter2 extends RecyclerView.Adapter <FeaturedAdapter2.FeaturedViewHolder2>{
private FeaturedViewHolder2.RecyclerViewClickListener listener;
Context context;


    ArrayList <FeaturedHelperClass2> featuredLocations2;

    public FeaturedAdapter2(ArrayList<FeaturedHelperClass2> featuredLocations2, FeaturedViewHolder2.RecyclerViewClickListener listener) {
        this.featuredLocations2 = featuredLocations2;

        this.context = context;
        this.listener = listener;
    }

    @NonNull

    @Override
    public FeaturedViewHolder2 onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design2, parent, false);

        FeaturedViewHolder2 featuredViewHolder2 = new FeaturedViewHolder2(view);
        return featuredViewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull  FeaturedAdapter2.FeaturedViewHolder2 holder, int position) {


        FeaturedHelperClass2 featuredHelperClass2 = featuredLocations2.get(position);

        holder.image.setImageResource(featuredHelperClass2.getImage());
        holder.title.setText(featuredHelperClass2.getTitle());
        holder.desc.setText(featuredHelperClass2.getDescription()); 
    }

    @Override
    public int getItemCount() {

        return featuredLocations2.size();
    }

    public static class FeaturedViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView title, desc;
        private FeaturedViewHolder2.RecyclerViewClickListener listener;

        public FeaturedViewHolder2(@NonNull  View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.featured_image2);
            title = itemView.findViewById(R.id.featured_title2);
            desc = itemView.findViewById(R.id.featured_desc2);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            listener.onclick(itemView, getAdapterPosition());


        }

        public interface RecyclerViewClickListener{
            void onclick (View v, int position);
        }

    }

}
