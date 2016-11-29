package com.mroto.jjd311_p2_adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyListAdapterRecycler extends RecyclerView.Adapter<MyListAdapterRecycler.ViewHolder> {

    private static final String TAG = MyListAdapterRecycler.class.getSimpleName();

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon_ImgView;
        public TextView title_TxtView;
        public TextView body_TxtView;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.e(MyListAdapterRecycler.TAG, "ViewHolder");
            //findViewById only called when instance the ViewHolder
            this.icon_ImgView = (ImageView) itemView.findViewById(R.id.img_view_custom_row_layout);
            this.title_TxtView = (TextView) itemView.findViewById(R.id.text_view_custom_title);
            this.body_TxtView = (TextView) itemView.findViewById(R.id.text_view_custom_body);
        }
    }

    Context mContext;
    private List<Item> itemList;

    public MyListAdapterRecycler(Context context, List<Item> objects) {
        Log.e(MyListAdapterRecycler.TAG, "MyListAdapterRecycler");
        this.mContext = context;
        this.itemList = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        Log.e(MyListAdapterRecycler.TAG, "onCreateViewHolder");
        View viewRow = LayoutInflater.from(this.mContext).inflate(R.layout.list_view_custom_layout, parent, false);
        viewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(MyListAdapterRecycler.TAG, "onClick");
                Toast.makeText(mContext, "onClick", Toast.LENGTH_SHORT).show();
            }
        });
        ViewHolder viewHolder = new ViewHolder(viewRow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.e(MyListAdapterRecycler.TAG, "onBindViewHolder");
        holder.title_TxtView.setText(this.itemList.get(position).getTitle());
        holder.body_TxtView.setText(this.itemList.get(position).getBody());

        //String strImgRef = this.itemList.get(position).getImageRef();
        //int imgId=this.mContext.getResources().getIdentifier(strImgRef , "drawable", this.mContext.getPackageName());
        //holder.icon_ImgView.setImageResource(imgId);
    }

    @Override
    public int getItemCount() {
        Log.e(MyListAdapterRecycler.TAG, "getItemCount");
        return this.itemList.size();
    }
}