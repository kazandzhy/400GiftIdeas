package kazandzhy.com;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// SQLite
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static android.content.Context.MODE_PRIVATE;

// make adapter for our GridView
public final class GiftIdeasActivityAdapter extends BaseAdapter {

    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;
    int age;
    String gender;
    String interest;
    String extra;
    String event;
    String category;
    String query;

    public GiftIdeasActivityAdapter(Context context, Intent intent) {

        // LayoutInflater class takes as input an XML file
        // and builds the View objects from it.
        mInflater = LayoutInflater.from(context);

        age = intent.getIntExtra("age", 0);
        gender = intent.getStringExtra("gender");
        interest = intent.getStringExtra("interest");
        extra = intent.getStringExtra("extra");
        event = intent.getStringExtra("event");
        category = intent.getStringExtra("category");
        query = null;

        // SQLite
        try {
            if (category.equals("by event dating")) {
                if(gender.equals("female")) {
                    query = "SELECT * FROM giftIdeas WHERE event = 'dating' AND female = 'TRUE' ORDER BY name";
                }
                else if(gender.equals("male")) {
                    query = "SELECT * FROM giftIdeas WHERE event = 'dating' AND male = 'TRUE' ORDER BY name";
                }
            }
            else if (category.equals("by event")) {
                query = "SELECT * FROM giftIdeas WHERE event = '" + event + "' ORDER BY name";
            }
            else if (category.equals("extras")) {
                query = "SELECT * FROM giftIdeas WHERE extra = '" + extra + "' ORDER BY name";
            }
            else if (category.equals("by age 0-3")) {
                if(age == 0) {
                    query = getQueryAge0_3("newborn", gender);
                } else if (age == 3) {
                    query = getQueryAge0_3("age1_3", gender);
                }
            }
            else if (category.equals("by age 4-12") || category.equals("by age more 12")) {
                if(age == 6) {
                    query = getQueryAge("age4_6", gender, interest);
                } else if (age == 9) {
                    query = getQueryAge("age7_9", gender, interest);
                } else if (age == 12) {
                    query = getQueryAge("age10_12", gender, interest);
                } else if(age == 16) {
                    query = getQueryAge("age13_19", gender, interest);
                } else if (age == 25) {
                    query = getQueryAge("age20_30", gender, interest);
                } else if (age == 35) {
                    query = getQueryAge("age30_40", gender, interest);
                } else if (age == 45) {
                    query = getQueryAge("age40_50", gender, interest);
                } else if (age == 55) {
                    query = getQueryAge("ageMore50", gender, interest);
                }
            }

            SQLiteDatabase sqLiteDatabase = context.openOrCreateDatabase("giftIdeas", MODE_PRIVATE, null);


            Cursor c = sqLiteDatabase.rawQuery(query, null);



            int giftIdIndex = c.getColumnIndex("_id");
            int giftNameIndex = c.getColumnIndex("name");
            int giftPictureIndex = c.getColumnIndex("pictureFileName");

           /*

           c.moveToFirst();

           while (c != null) {

                String drawableName = c.getString(giftPictureIndex);
                int giftId = c.getInt(giftIdIndex);
                int resID = context.getResources().getIdentifier(drawableName, "drawable", context.getPackageName());

                mItems.add(new Item(c.getString(giftNameIndex), resID, giftId));

                c.moveToNext();
            }
            */
            while (c.moveToNext()) {

                String drawableName = c.getString(giftPictureIndex);
                int giftId = c.getInt(giftIdIndex);
                int resID = context.getResources().getIdentifier(drawableName, "drawable", context.getPackageName());

                mItems.add(new Item(c.getString(giftNameIndex), resID, giftId));
            }


            c.close();
            sqLiteDatabase.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getQueryAge0_3(String ageGroup, String gender) {
        query = "SELECT * FROM giftIdeas WHERE " + ageGroup + " = 'TRUE' AND " + gender + " = 'TRUE' ORDER BY name";
        return query;
    }

    public String getQueryAge(String ageGroup, String gender, String interest) {
        query = "SELECT * FROM giftIdeas WHERE " + ageGroup + " = 'TRUE' AND " + gender + " = 'TRUE' AND " + interest + " = 'TRUE' ORDER BY name";
        return query;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        picture.setId(item.giftId);
        name.setText(item.name);

        return v;
    }

    static class Item {
        private final String name;
        private final int drawableId;
        private final int giftId;

        Item(String name, int drawableId, int giftId) {
            this.name = name;
            this.drawableId = drawableId;
            this.giftId = giftId;
        }

        public String getName() {
            return name;
        }

        public int getDrawableId() {
            return drawableId;
        }

        public int getGiftId() {
            return giftId;
        }
    }
}

