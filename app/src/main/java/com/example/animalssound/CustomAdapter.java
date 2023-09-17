package com.example.animalssound;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private final Activity activity;
    private final String[] animals;
    private final int[] animalsImage;
    private OnItemClickListener clickListener;

    public CustomAdapter(Activity activity, String[] animals, int[] animalsImage) {
        this.activity = activity;
        this.animals = animals;
        this.animalsImage = animalsImage;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= activity.getLayoutInflater();
        View view= inflater.inflate(R.layout.card_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onItemClick(position);
                }
            }
        });
    holder.textView.setText(animals[position]);
    holder.imageView.setImageResource(animalsImage[position]);
    Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), animalsImage[position]);
    Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, true);

    // Set the resized bitmap to the ImageView
        holder.imageView.setImageBitmap(resizedBitmap);
    }

    @Override
    public int getItemCount() {
        return animals.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        textView=itemView.findViewById(R.id.tv);
        imageView=itemView.findViewById(R.id.iv);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }
}

