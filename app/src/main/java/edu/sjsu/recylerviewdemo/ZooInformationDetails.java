package edu.sjsu.recylerviewdemo;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ZooInformationDetails extends animalListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_information_details);

        Button phone = (Button) findViewById(R.id.button);
        try {
            phone.setOnClickListener(new ClickHandler());
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    private class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    try {
                        String number = "tel: 888-8888";
                        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
                        startActivity(callIntent);
                    break;
                    } catch (Exception e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

            }
        }
    }


}