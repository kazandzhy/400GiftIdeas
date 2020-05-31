package kazandzhy.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class ExtrasActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_extras);

        imageButton1 = (ImageButton) findViewById(R.id.flowersGroupImageButton);
        imageButton1.setOnClickListener(listener);

        imageButton2 = (ImageButton) findViewById(R.id.homemadeGroupImageButton);
        imageButton2.setOnClickListener(listener);

        imageButton3 = (ImageButton) findViewById(R.id.greetingCardGroupImageButton);
        imageButton3.setOnClickListener(listener);

        imageButton4 = (ImageButton) findViewById(R.id.perfumeGroupImageButton);
        imageButton4.setOnClickListener(listener);

        imageButton5 = (ImageButton) findViewById(R.id.giftCardGroupImageButton);
        imageButton5.setOnClickListener(listener);

        imageButton6 = (ImageButton) findViewById(R.id.packagingGroupImageButton);
        imageButton6.setOnClickListener(listener);

        imageButton7 = (ImageButton) findViewById(R.id.makeUpGroupImageButton);
        imageButton7.setOnClickListener(listener);

        imageButton8 = (ImageButton) findViewById(R.id.sweetGroupImageButton);
        imageButton8.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.flowersGroupImageButton:
                    passIntent("flowers");
                    break;
                case R.id.homemadeGroupImageButton:
                    passIntent("homemade");
                    break;
                case R.id.greetingCardGroupImageButton:
                    passIntent("greetingcards");
                    break;
                case R.id.perfumeGroupImageButton:
                    passIntent("fragrance");
                    break;
                case R.id.giftCardGroupImageButton:
                    passIntent("giftcards");
                    break;
                case R.id.packagingGroupImageButton:
                    passIntent("wrapping");
                    break;
                case R.id.makeUpGroupImageButton:
                    passIntent("makeup");
                    break;
                case R.id.sweetGroupImageButton:
                    passIntent("sweets");
                    break;
            }
        }
    };

    protected void passIntent(String extra) {
        intent = new Intent(getApplicationContext(), GiftIdeasActivity.class);
        intent.putExtra("extra", extra);
        intent.putExtra("category", "extras");
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
