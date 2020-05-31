package kazandzhy.com;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GiftIdeaActivity extends AppCompatActivity {

    Intent intent;
    int giftId;
    String giftIdeaName;
    String giftIdeaDescription;
    String giftIdeaPictureFileName;
    String giftIdeaSiteURL;

    TextView giftIdeaNameTextView;
    TextView giftIdeaDesriptionTextView;
    TextView giftIdeaSiteURLTextView;
    ImageView giftIdeaImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_idea);

        giftIdeaNameTextView = findViewById(R.id.giftIdeaNameTextView);
        giftIdeaDesriptionTextView = findViewById(R.id.giftIdeaDesriptionTextView);
        giftIdeaSiteURLTextView = findViewById(R.id.giftIdeaSiteURLTextView);
        giftIdeaImageView = findViewById(R.id.giftIdeaImageView);

        intent = getIntent();
        giftId = intent.getIntExtra("giftId", 0);

        showGiftIdeaContent();
    }

    public void showGiftIdeaContent() {

        // SQLite
        try {
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("giftIdeas", MODE_PRIVATE, null);

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM giftIdeas WHERE _id = " + giftId, null);
            c.moveToFirst();

            giftIdeaName = c.getString(c.getColumnIndex("name"));
            giftIdeaDescription = c.getString(c.getColumnIndex("description"));
            giftIdeaPictureFileName = c.getString(c.getColumnIndex("pictureFileName"));
            giftIdeaSiteURL = c.getString(c.getColumnIndex("siteURL"));

            sqLiteDatabase.close();
            resetGiftIdeaContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetGiftIdeaContent() {

        giftIdeaNameTextView.setText(giftIdeaName);
        giftIdeaDesriptionTextView.setText(giftIdeaDescription);
        giftIdeaSiteURLTextView.setText(R.string.gift_idea_url);
        giftIdeaImageView.setImageDrawable(getDrawable(this.getResources().getIdentifier(giftIdeaPictureFileName, "drawable", this.getPackageName())));
    }

    public void openWebsite(View view) {
        // Start Chrome
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(giftIdeaSiteURL));// Constructs the URL
        startActivity(browserIntent);
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
