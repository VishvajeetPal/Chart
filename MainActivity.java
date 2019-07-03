package com.example.vishvajeet.test_application;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.db.chart.model.LineSet;
import com.db.chart.view.LineChartView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   final String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; // Your List / array with String Values For X-axis Labels

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LineChart lineChart = findViewById(R.id.line1);
        YAxis yAxis = lineChart.getAxisRight();
        yAxis.setEnabled(false);
        YAxis lyAxis = lineChart.getAxisLeft();
        lyAxis.setEnabled(true);
        lyAxis.setAxisLineColor(Color.parseColor("#2c3542"));
        lyAxis.setTextSize(13);
        lyAxis.setTextColor(Color.parseColor("#ffffff"));
        XAxis xAxis = lineChart.getXAxis();;
        xAxis.setTextColor(Color.parseColor("#ffffff"));
        xAxis.setAxisLineWidth(3);
        xAxis.setTextSize(13);
        xAxis.setAxisLineColor(Color.parseColor("#ffffff"));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(weekdays));
        /*lineChart.setDragEnabled(true);*/
        lineChart.setScaleEnabled(false);
        /*lineChart.setPinchZoom(true);*/
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getDescription().setText("");
        lineChart.getLegend().setEnabled(false);
        lineChart.setExtraBottomOffset(10);
        lineChart.animateXY(3000,3000,Easing.EasingOption.EaseInBounce,Easing.EasingOption.EaseInBounce);



        ArrayList<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(0,6f));
        yValues.add(new Entry(1,3f));
        yValues.add(new Entry(2,10f));
        yValues.add(new Entry(3,9f));
        yValues.add(new Entry(4,13f));
        yValues.add(new Entry(5,2f));
        yValues.add(new Entry(6,1f));



        LineDataSet set1 = new LineDataSet(yValues,"Set 1");
        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set1.setDrawFilled(true);
        set1.setFillColor(Color.parseColor("#1fc6b2"));
        set1.setDrawValues(false);
        set1.setLineWidth(5f);
        set1.setFillAlpha(100);
        set1.setDrawCircles(false);
        set1.setColor(Color.parseColor("#1fc6b2"));
        ArrayList<ILineDataSet>dataset = new ArrayList<>();
        dataset.add(set1);
        LineData data = new LineData(dataset);
        lineChart.setData(data);
        }

}
