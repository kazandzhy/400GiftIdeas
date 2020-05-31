package kazandzhy.com;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = (ImageButton) findViewById(R.id.giftsByAgeImageButton);
        imageButton.setOnClickListener(listener);

        imageButton2 = (ImageButton) findViewById(R.id.giftsByEventImageButton);
        imageButton2.setOnClickListener(listener);

        imageButton3 = (ImageButton) findViewById(R.id.extrasImageButton);
        imageButton3.setOnClickListener(listener);


        DataBaseHelper myDbHelper = new DataBaseHelper(this);


        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.giftsByAgeImageButton:
                    passIntent(GiftsByAgeActivity.class);
                    break;
                case R.id.giftsByEventImageButton:
                    passIntent(GiftsByEventActivity.class);
                    break;
                case R.id.extrasImageButton:
                    passIntent(ExtrasActivity.class);
                    break;
            }
        }
    };

    protected void passIntent(Class MyClass) {
        intent = new Intent(getApplicationContext(), MyClass);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        switch (item.getItemId()) {
            case R.id.action_about:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            case R.id.action_gift_advice:
                startActivity(new Intent(this, GiftAdviceActivity.class));
                return true;
            case R.id.action_random_gift:
                startActivity(new Intent(this, RandomGiftActivity.class));
                return true;
            case R.id.action_contact_us:
                startActivity(new Intent(this, ContactUsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
