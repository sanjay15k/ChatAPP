package com.nsit.chatapp.Adapters;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nsit.chatapp.R;

import com.nsit.chatapp.DTO.MessageDTO;

import java.util.ArrayList;

public class MessagesListViewAdapter extends RecyclerView.Adapter<MessagesListViewAdapter.ViewHolder> {

    private ArrayList<MessageDTO> messageDTOArrayList;
    private Context context;
    private String currentUserUID;

    public MessagesListViewAdapter(ArrayList<MessageDTO> messageDTOArrayList, Context context, String currentUserUID) {
        this.messageDTOArrayList = messageDTOArrayList;
        this.context = context;
        this.currentUserUID = currentUserUID;
    }

    @Override
    public MessagesListViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.message_layout,parent,false));
    }

    // Overriden because items were changing position on scroll , u can also check on removing this method
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(MessagesListViewAdapter.ViewHolder holder, int position) {
        MessageDTO messageDTO = messageDTOArrayList.get(position);
        if (messageDTO != null){
            if (messageDTO.getFrom().equals(currentUserUID)){
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
                holder.friendMessageLinearLayout.setLayoutParams(layoutParams);

                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams2.gravity = Gravity.RIGHT;
                holder.friendMessageLinearLayout2.setLayoutParams(layoutParams2);

                holder.friendMessageTextView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

                LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                params3.setMargins(0,0,15,0);
                holder.friendMessageTimeTextView.setLayoutParams(params3);
                holder.friendMessageTimeTextView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

            }
            holder.friendMessageTextView.setText(messageDTO.getMessage());
            holder.friendMessageTimeTextView.setText(messageDTO.getTimeStamp());
        }
        else{
            Toast.makeText(context,"Start chat to see messages!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int getItemCount() {
        return messageDTOArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout friendMessageLinearLayout;
        private LinearLayout friendMessageLinearLayout2;
        private TextView friendMessageTextView;
        private TextView friendMessageTimeTextView;

        ViewHolder(View itemView) {
            super(itemView);
            friendMessageLinearLayout = itemView.findViewById(R.id.friendMessageLinearLayout);
            friendMessageLinearLayout2 = itemView.findViewById(R.id.friendMessageLinearLayout2);
            friendMessageTextView = itemView.findViewById(R.id.friendMessageTextView);
            friendMessageTimeTextView = itemView.findViewById(R.id.friendMessageTimeTextView);
        }

    }
}
