package com.mycompany.mydial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/4.
 */

public class ConnectorAdapter extends RecyclerView.Adapter<ConnectorAdapter.ViewHolder> {


    private List<Connector> connectorList;

    public ConnectorAdapter(List<Connector> connectorsList) {
        connectorList = connectorsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.connector_detail, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.phoneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Connector connector = connectorList.get(position);
                Intent callIntent =new Intent("android.intent.action.CALL",Uri.parse("tel:" + connector.getPhone_number()) );
                view.getContext().startActivity(callIntent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Connector connector = connectorList.get(position);
        holder.nametext.setText(connector.getName());
        holder.timeText.setText(connector.getTime());
        holder.phone_number.setText(connector.getPhone_number());

    }

    @Override
    public int getItemCount() {
        return connectorList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nametext;
        TextView phone_number;
        TextView timeText;
        ImageView phoneImage;


        public ViewHolder(View itemView) {
            super(itemView);
            nametext = (TextView)itemView.findViewById(R.id.connector_name);
            phone_number = (TextView)itemView.findViewById(R.id.connector_phone_number);
            timeText = (TextView)itemView.findViewById(R.id.times);
            phoneImage = (ImageView)itemView.findViewById(R.id.phone_image);
        }
    }
}
