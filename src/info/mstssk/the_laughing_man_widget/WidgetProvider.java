package info.mstssk.the_laughing_man_widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {

	private static int hOffset = 360;

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		// super.onUpdate(context, appWidgetManager, appWidgetIds);
		for (int i : appWidgetIds) {
			updateAppWidget(context, appWidgetManager, i);
		}
	}

	static void updateAppWidget(Context context, AppWidgetManager manager,
			int app_widget_id) {
		RemoteViews views = new RemoteViews(context.getPackageName(),
				R.layout.widgetlayout);
		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.c00);
		// Bitmap bitmap = Bitmap.createBitmap(144, 144,
		// Bitmap.Config.ARGB_4444);
		Canvas canvas = new Canvas(bitmap);
		Path path = new Path();
		path.addCircle(72, 72, 60, Direction.CW);
		// RectF rectf = new RectF(2, 2, 142, 142);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		String str = context.getString(R.string.str);
		canvas.drawTextOnPath(str, path, hOffset, 0, paint);
		if (hOffset <= 0) {
			hOffset = 360;
		} else {
			hOffset -= 1;
		}
		canvas.drawPath(path, paint);
		views.setImageViewResource(R.id.widgetview, R.drawable.c00);
		views.setImageViewBitmap(R.id.widgetview, bitmap);
		manager.updateAppWidget(app_widget_id, views);
	}

}
