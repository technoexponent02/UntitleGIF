package com.etebarian.meowbottomnavigaion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.etebarian.meowbottomnavigaion.R;
import com.etebarian.meowbottomnavigaion.model.ScreenBO;

import java.util.List;

public class ScreenAdapter extends RecyclerView.Adapter<ScreenAdapter.ScreenViewHolder>{

    private Context context;
    private List<ScreenBO> screenBOList;

    public ScreenAdapter(Context context, List<ScreenBO> screenBOList) {
        this.context = context;
        this.screenBOList = screenBOList;
    }

    @NonNull
    @Override
    public ScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.screen_one_list, null);
        ScreenViewHolder rcv = new ScreenViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull ScreenViewHolder holder, int position) {

        holder.txtOne.setText(screenBOList.get(position).getTitle());
        holder.txtTwo.setText(screenBOList.get(position).getAddress());

        if (screenBOList.get(position).getPrice() == null || screenBOList.get(position).getPrice().equals("")){
            holder.txtThree.setVisibility(View.GONE);
        }else {
            holder.txtThree.setVisibility(View.VISIBLE);
            holder.txtThree.setText(screenBOList.get(position).getPrice());
        }

    }

    @Override
    public int getItemCount() {
        return screenBOList.size();
    }

    class ScreenViewHolder extends RecyclerView.ViewHolder{

        TextView txtOne, txtTwo, txtThree;

        public ScreenViewHolder(View itemView) {
            super(itemView);

            txtOne = (TextView) itemView.findViewById(R.id.txtOne);
            txtTwo = (TextView) itemView.findViewById(R.id.txtTwo);
            txtThree = (TextView) itemView.findViewById(R.id.txtThree);

        }
    }
}
