package info.mstssk.the_laughing_man_widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.view.View;

public class GraphicsView extends View {

	public GraphicsView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Canvas canvas) {
		onDraw(canvas);
	};
	
	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.argb(255, 164, 199, 57));
		Path circle = new Path();
		circle.addCircle(60, 60, 50, Direction.CW);
		String str = getResources().getString(R.string.str);
		canvas.drawPath(circle, paint);
		canvas.drawTextOnPath(str, circle, 0, 0, paint);
		setBackgroundResource(R.drawable.c00);
	}
	
}
