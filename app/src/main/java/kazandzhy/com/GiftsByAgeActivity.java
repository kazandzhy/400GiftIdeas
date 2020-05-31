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

public class GiftsByAgeActivity extends AppCompatActivity {

    Intent intent;
    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    ImageButton imageButton7;
    ImageButton imageButton8;
    ImageButton imageButton9;
    ImageButton imageButton10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts_by_age);

        imageButton = (ImageButton) findViewById(R.id.ageNewbornImageButton);
        imageButton.setOnClickListener(listener);

        imageButton2 = (ImageButton) findViewById(R.id.age1_3ImageButton);
        imageButton2.setOnClickListener(listener);

        imageButton3 = (ImageButton) findViewById(R.id.age4_6ImageButton);
        imageButton3.setOnClickListener(listener);

        imageButton4 = (ImageButton) findViewById(R.id.age7_9ImageButton);
        imageButton4.setOnClickListener(listener);

        imageButton5 = (ImageButton) findViewById(R.id.age10_12ImageButton);
        imageButton5.setOnClickListener(listener);

        imageButton6 = (ImageButton) findViewById(R.id.age13_19ImageButton);
        imageButton6.setOnClickListener(listener);

        imageButton7 = (ImageButton) findViewById(R.id.age20_30ImageButton);
        imageButton7.setOnClickListener(listener);

        imageButton8 = (ImageButton) findViewById(R.id.age30_40ImageButton);
        imageButton8.setOnClickListener(listener);

        imageButton9 = (ImageButton) findViewById(R.id.age40_50ImageButton);
        imageButton9.setOnClickListener(listener);

        imageButton10 = (ImageButton) findViewById(R.id.ageMore50ImageButton);
        imageButton10.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ageNewbornImageButton:
                    passIntent(0, "by age 0-3");
                    break;
                case R.id.age1_3ImageButton:
                    passIntent(3, "by age 0-3");
                    break;
                case R.id.age4_6ImageButton:
                    passIntent(6, "by age 4-12");
                    break;
                case R.id.age7_9ImageButton:
                    passIntent(9, "by age 4-12");
                    break;
                case R.id.age10_12ImageButton:
                    passIntent(12, "by age 4-12");
                    break;
                case R.id.age13_19ImageButton:
                    passIntent(16, "by age more 12");
                    break;
                case R.id.age20_30ImageButton:
                    passIntent(25, "by age more 12");
                    break;
                case R.id.age30_40ImageButton:
                    passIntent(35, "by age more 12");
                    break;
                case R.id.age40_50ImageButton:
                    passIntent(45, "by age more 12");
                    break;
                case R.id.ageMore50ImageButton:
                    passIntent(55, "by age more 12");
                    break;
            }
        }
    };

    protected void passIntent(int age, String category) {
        intent = new Intent(getApplicationContext(), GenderActivity.class);
        intent.putExtra("age",age);
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
