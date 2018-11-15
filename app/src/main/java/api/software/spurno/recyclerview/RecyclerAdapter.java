package api.software.spurno.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private static final String TAG = "RecyclerAdapter";

    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(Context context, ArrayList<String> mName, ArrayList<String> mImages) {
        this.mName = mName;
        this.mImages = mImages;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflater_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(context)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.mImage);
        holder.mName.setText(mName.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + mName.get(position));
                Toast.makeText(context, mName.get(position), Toast.LENGTH_LONG).show();;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView mImage;
        TextView mName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: buinding layout");
            mImage = itemView.findViewById(R.id.images);
            mName = itemView.findViewById(R.id.name_text);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
