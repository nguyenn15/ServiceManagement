package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.amandeep.customerapplication.AcceptOrderActivity;
import com.example.amandeep.customerapplication.R;

import java.util.ArrayList;
import java.util.List;

import Model.ListItem;
import ORM.RequestResponse;


public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder> {

    private Context context; //current state of the class
    private List<ListItem> listItems;//create custom ListItem class


    public MyAdapter(Context context, List<ListItem> listItem) {
        this.context = context;
        listItems = listItem;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        ListItem listItem=listItems.get(position);

        holder.description.setText("Request Number: "+listItem.getId());
        holder.status.setText(listItem.getStatus());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView description;
        public TextView status;

        public ViewHolder(View itemView) {
            super(itemView);

            description=(TextView)itemView.findViewById(R.id.txtDescription);
            status=(TextView)itemView.findViewById(R.id.status);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            ListItem item= listItems.get(position);
             // get quote from database depending on request id
                Intent intent= new Intent(context, AcceptOrderActivity.class);
                intent.putExtra("requestId",item.getId());
                context.startActivity(intent);



        }


    }
}
