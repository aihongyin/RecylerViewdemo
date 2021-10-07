package edu.sjsu.recylerviewdemo;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdater extends RecyclerView.Adapter<CustomAdater.MyViewHolder> {

    List<Model> my_list;

    Context mContext;

    public CustomAdater(Context context) {
        this.mContext = context;
    }

    public CustomAdater(List<Model> my_list) {
        this.my_list = my_list;
    }

    public CustomAdater(List<Model> my_list, Context context) {
        this.my_list = my_list;
        this.mContext = context;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_list_item,parent,false);
        // set the view's size, margins, paddings and layout parameters

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        final Model model = my_list.get(position);
        holder.name.setText(model.getName());
        holder.description.setText(model.getDescription());
        holder.image.setImageDrawable(mContext.getResources().getDrawable(model.getImage()));


        holder.relative.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

              switch(model.getName()) {
                  case ("Panda"):
                  case("Tiger"):
                  case("Lion"):
                  case("Elephant"):
                  try {
                      Intent myIntent = new Intent(mContext, AnimalDetailsActivity.class);
                      myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                      myIntent.putExtra("image", model.getImage());
                      myIntent.putExtra("name", model.getName());
                      myIntent.putExtra("description", model.getDescription());

                      mContext.startActivity(myIntent);
                  } catch (Exception e) {
                      Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
                  }
                  break;


                //need to figure out how to make a dialog for "Snake"
               case("Snake"):
                   try {
                       AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                       alertDialog.setTitle("Attention!");
                       alertDialog.setMessage("The animal is very scary, do you want to proceed?");
                      // alertDialog.setPositiveButton("ok", null);
                       alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                               Intent myIntent = new Intent(mContext, AnimalDetailsActivity.class);
                               myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                               myIntent.putExtra("image", model.getImage());
                               myIntent.putExtra("name", model.getName());
                               myIntent.putExtra("description", model.getDescription());

                               mContext.startActivity(myIntent);

                           }});

                       alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.cancel();
                           }
                       });
                       alertDialog.show();

                   }catch (Exception e) {
                       Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
                   }
                   break;
                   }




              }
            }
            );






    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView description;
        RelativeLayout relative;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            relative = itemView.findViewById(R.id.relative);
        }
    }

}


