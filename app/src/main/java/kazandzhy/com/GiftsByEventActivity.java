package kazandzhy.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class GiftsByEventActivity extends AppCompatActivity {

    Intent intent;
    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    ImageButton imageButton7;
    ImageButton imageButton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts_by_event);

        imageButton1 = (ImageButton) findViewById(R.id.newbornImageButton);
        imageButton1.setOnClickListener(listener);

        imageButton2 = (ImageButton) findViewById(R.id.christmasImageButton);
        imageButton2.setOnClickListener(listener);

        imageButton3 = (ImageButton) findViewById(R.id.datingImageButton);
        imageButton3.setOnClickListener(listener);

        imageButton4 = (ImageButton) findViewById(R.id.newlywedsImageButton);
        imageButton4.setOnClickListener(listener);

        imageButton5 = (ImageButton) findViewById(R.id.mothersDayImageButton);
        imageButton5.setOnClickListener(listener);

        imageButton6 = (ImageButton) findViewById(R.id.fathersDayImageButton);
        imageButton6.setOnClickListener(listener);

        imageButton7 = (ImageButton) findViewById(R.id.housewarmingImageButton);
        imageButton7.setOnClickListener(listener);

        imageButton8 = (ImageButton) findViewById(R.id.graduationImageButton);
        imageButton8.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.newbornImageButton:
                    passOtherIntent(0);
                    break;
                case R.id.christmasImageButton:
                    passIntent("christmas");
                    break;
                case R.id.datingImageButton:
                    passThirdIntent("dating");
                    break;
                case R.id.newlywedsImageButton:
                    passIntent("newlyweds");
                    break;
                case R.id.mothersDayImageButton:
                    passIntent("mothers");
                    break;
                case R.id.fathersDayImageButton:
                    passIntent("fathers");
                    break;
                case R.id.housewarmingImageButton:
                    passIntent("housewarming");
                    break;
                case R.id.graduationImageButton:
                    passIntent("graduation");
                    break;
            }
        }
    };

    protected void passIntent(String event) {
        intent = new Intent(getApplicationContext(), GiftIdeasActivity.class);
        intent.putExtra("event",event);
        intent.putExtra("category", "by event");
        startActivity(intent);
    }

    protected void passOtherIntent(int age) {
        intent = new Intent(getApplicationContext(), GenderActivity.class);
        intent.putExtra("age",age);
        intent.putExtra("category", "by age 0-3");
        startActivity(intent);
    }

    protected void passThirdIntent(String event) {
        intent = new Intent(getApplicationContext(), GenderActivity.class);
        intent.putExtra("event",event);
        intent.putExtra("category", "by event dating");
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
