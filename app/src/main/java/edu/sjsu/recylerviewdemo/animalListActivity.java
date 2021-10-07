package edu.sjsu.recylerviewdemo;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;


public class animalListActivity extends AppCompatActivity {

    //test
    Context mContext;


    RecyclerView recyclerView;
    List<Model> main_list;
    RecyclerView.Adapter adapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                startActivity(new Intent(this, ZooInformationDetails.class));
                return true;

            case R.id.item2:

                Intent intent = new Intent(Intent.ACTION_DELETE);

                intent.setData(Uri.parse("package:edu.sjsu.recylerviewdemo"));
                startActivity(intent);

                return true;
            default:return super.onOptionsItemSelected(item);

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


            mContext = this;
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_animal_list);

            main_list = new ArrayList<>();
            recyclerView = findViewById(R.id.recycler);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            main_list.add(new Model(R.drawable.panda, "Panda", "The giant panda, " +
                    "also known as the panda bear, is a bear native to South Central China. " +
                    "It is characterised by its bold black-and-white coat and rotund body. "));
            main_list.add(new Model(R.drawable.tiger, "Tiger", "The tiger is the " +
                    "largest living cat species and a member of the genus Panthera. It is most " +
                    "recognisable for its dark vertical stripes on orange-brown fur with a " +
                    "lighter underside."));
            main_list.add(new Model(R.drawable.lion, "Lion", "The lion is a large " +
                    "cat of the genus Panthera native to Africa and India. It has a muscular, " +
                    "deep-chested body, short, rounded head, round ears, and a hairy tuft at the " +
                    "end of its tail."));
            main_list.add(new Model(R.drawable.elephant, "Elephant", "Elephants " +
                    "are the largest existing land animals. Three living species are currently " +
                    "recognised: the African bush elephant, the African forest elephant, and the " +
                    "Asian elephant."));
            main_list.add(new Model(R.drawable.snake, "Snake","Snakes are elongated, " +
                    "limbless, carnivorous reptiles of the suborder Serpentes. Like all other squamates, " +
                    "snakes are ectothermic, amniote vertebrates covered in overlapping scales."));


            // define an adapter
            CustomAdater mAdapter = new CustomAdater(main_list, getApplicationContext());
            recyclerView.setAdapter(mAdapter);




    }


    }




