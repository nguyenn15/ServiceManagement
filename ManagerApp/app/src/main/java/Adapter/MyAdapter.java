package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.johal.companysystem.OrderDetails;
import com.example.johal.companysystem.R;

import java.util.List;

import Model.ListItem;




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

        holder.description.setText(listItem.getDescription());
        holder.statusText.setText(listItem.getButtonText());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView description;
        public TextView statusText;


        public ViewHolder(View itemView) {
            super(itemView);

            description=(TextView)itemView.findViewById(R.id.txtDescription);
            itemView.setOnClickListener(this);

            statusText=(TextView) itemView.findViewById(R.id.statusText);

        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            ListItem item= listItems.get(position);
            Intent intent= new Intent(context, OrderDetails.class);
            intent.putExtra("order_number",item.getDescription());
            context.startActivity(intent);

        }
    }
}
