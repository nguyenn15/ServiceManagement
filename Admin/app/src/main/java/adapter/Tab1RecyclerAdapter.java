package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a300273215.admin.R;
import com.example.a300273215.admin.SendQuoteToCustomer;

import java.util.List;

import model.ListItem;

/**
 * Created by 300272368 on 7/8/2018.
 */

public class Tab1RecyclerAdapter extends RecyclerView.Adapter<Tab1RecyclerAdapter.ViewHolder>  {

    private Context context; //current state of the class
    private List<ListItem> listItems;//create custom ListItem class

    public Tab1RecyclerAdapter(Context context, List<ListItem> listItem) {
        this.context = context;
        listItems = listItem;
    }

    @Override
    public Tab1RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_recycler,parent,false);

        return new Tab1RecyclerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Tab1RecyclerAdapter.ViewHolder holder, int position) {
        ListItem listItem=listItems.get(position);

        holder.description.setText("Request Number " + listItem.getId());
        holder.statusText.setText(listItem.getStatus());

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
            Intent myIntent = new Intent(context,
                    SendQuoteToCustomer.class);
            myIntent.putExtra("id",item.getId());
            myIntent.putExtra("idCustomer",item.getIdCustomer());
            context. startActivity(myIntent);


        }
    }
}
