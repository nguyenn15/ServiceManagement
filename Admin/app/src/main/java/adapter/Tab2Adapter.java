package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import com.example.a300273215.admin.R;
import com.example.a300273215.admin.SendQuoteToCustomer;
import com.example.a300273215.admin.SendToManager;

import ORM.RequestOrder;
import model.ListItem;

/**
 * Created by 300273215 on 7/3/2018.
 */

public class Tab2Adapter extends RecyclerView.Adapter<Tab2Adapter.ViewHolder> {
    private Context context; //current state of the class
    private List<ListItem> listItems;//create custom ListItem class

    public Tab2Adapter(Context context, List<ListItem> listItem) {
        this.context = context;
        listItems = listItem;
    }

    @Override
    public Tab2Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Tab2Adapter.ViewHolder holder, int position) {
        ListItem listItem=listItems.get(position);

        holder.description.setText("Order Number " + listItem.getId());
        holder.statusText.setText(RequestOrder.STATUS.FromInt(Integer.parseInt(listItem.getStatus()))+"");

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
                    SendToManager.class);
            myIntent.putExtra("requestId",item.getId());

            context. startActivity(myIntent);

        }
    }
}
