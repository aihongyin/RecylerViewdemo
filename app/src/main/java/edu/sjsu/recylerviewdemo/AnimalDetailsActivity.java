package edu.sjsu.recylerviewdemo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetailsActivity extends animalListActivity {
    ImageView imageView;
    TextView name, description;
    String anName, anDescription;
    int anImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);
        imageView = findViewById(R.id.image);
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        anName = getIntent().getStringExtra("name");
        anImage= getIntent().getIntExtra("image", 0);
        anDescription = getIntent().getStringExtra("description");

        name.setText(anName);
        description.setText(anDescription);
        imageView.setImageResource(anImage);




    }
}