package kazandzhy.com;

import android.content.Context;
import android.util.AttributeSet;

// Make a custom ImageView that maintains its aspect ratio
public class GiftIdeasActivitySquareImageView extends android.support.v7.widget.AppCompatImageView {
    public GiftIdeasActivitySquareImageView(Context context) {
        super(context);
    }

    public GiftIdeasActivitySquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GiftIdeasActivitySquareImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth()); //Snap to width
    }
}
