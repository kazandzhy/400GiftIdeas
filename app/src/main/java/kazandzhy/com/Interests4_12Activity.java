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

public class Interests4_12Activity extends AppCompatActivity {

    Intent intent;
    int age;
    String gender;
    String category;
    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests4_12);

        imageButton1 = (ImageButton) findViewById(R.id.sportsFanImageButton);
        imageButton1.setOnClickListener(listener);

        imageButton2 = (ImageButton) findViewById(R.id.fashionGuruImageButton);
        imageButton2.setOnClickListener(listener);

        imageButton3 = (ImageButton) findViewById(R.id.intellectualImageButton);
        imageButton3.setOnClickListener(listener);

        imageButton4 = (ImageButton) findViewById(R.id.outdoorsyImageButton);
        imageButton4.setOnClickListener(listener);

        imageButton5 = (ImageButton) findViewById(R.id.artLoverImageButton);
        imageButton5.setOnClickListener(listener);

        imageButton6 = (ImageButton) findViewById(R.id.musicFanImageButton);
        imageButton6.setOnClickListener(listener);

        intent = getIntent();
        age = intent.getIntExtra("age", 0);
        gender = intent.getStringExtra("gender");
        category = intent.getStringExtra("category");
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sportsFanImageButton:
                    passIntent(gender, age, "sport");
                    break;
                case R.id.fashionGuruImageButton:
                    passIntent(gender, age, "fashion");
                    break;
                case R.id.intellectualImageButton:
                    passIntent(gender, age, "intellect");
                    break;
                case R.id.outdoorsyImageButton:
                    passIntent(gender, age, "outdoor");
                    break;
                case R.id.artLoverImageButton:
                    passIntent(gender, age, "art");
                    break;
                case R.id.musicFanImageButton:
                    passIntent(gender, age, "music");
                    break;
            }
        }
    };

    protected void passIntent(String gender, int age, String interest) {
        intent = new Intent(getApplicationContext(), GiftIdeasActivity.class);
        intent.putExtra("age",age);
        intent.putExtra("gender", gender);
        intent.putExtra("interest", interest);
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
