package kazandzhy.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class GenderActivity extends AppCompatActivity {

    Intent intent;
    int age;
    String category;
    String event = null;
    ImageButton imageButton;
    ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        imageButton = (ImageButton) findViewById(R.id.genderFemaleImageButton);
        imageButton.setOnClickListener(listener);

        imageButton2 = (ImageButton) findViewById(R.id.genderMaleImageButton);
        imageButton2.setOnClickListener(listener);

        intent = getIntent();
        age = intent.getIntExtra("age", 0);
        category = intent.getStringExtra("category");
        event = intent.getStringExtra("event");
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.genderFemaleImageButton:
                    passIntent("female", age, event);
                    break;
                case R.id.genderMaleImageButton:
                    passIntent("male", age, event);
                    break;
            }
        }
    };

    protected void passIntent(String gender, int age, String event) {
        if(event != null) {
            intent = new Intent(getApplicationContext(), GiftIdeasActivity.class);
            intent.putExtra("event", event);
        }
        if (age == 0 || age == 3)
        {
            intent = new Intent(getApplicationContext(), GiftIdeasActivity.class);
        } else if (age == 6 || age == 9 || age == 12) {
            intent = new Intent(getApplicationContext(), Interests4_12Activity.class);
        }
        else {
            intent = new Intent(getApplicationContext(), InterestsActivity.class);
        }

        intent.putExtra("age",age);
        intent.putExtra("gender", gender);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_others, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        switch (item.getItemId()) {
            case R.id.action_home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
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
