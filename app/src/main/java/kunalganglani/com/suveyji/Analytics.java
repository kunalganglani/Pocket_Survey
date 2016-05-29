package kunalganglani.com.suveyji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class Analytics extends AppCompatActivity {
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);
        Spinner dropdown = (Spinner)findViewById(R.id.spinner2);
        String[] items = new String[]{"Bar Graph", "Pie Chart"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BarChart barChart = (BarChart) findViewById(R.id.chart);
                PieChart pieChart = (PieChart) findViewById(R.id.piechart);

                switch (position) {
                    case 0:
                        pieChart.setVisibility(View.INVISIBLE);
                        barChart.setVisibility(View.VISIBLE);

                        // HorizontalBarChart barChart= (HorizontalBarChart) findViewById(R.id.chart);

                        ArrayList<BarEntry> entries1 = new ArrayList<>();
                        entries1.add(new BarEntry(4f, 0));
                        entries1.add(new BarEntry(8f, 1));
                        entries1.add(new BarEntry(6f, 2));
                        entries1.add(new BarEntry(12f, 3));
                        entries1.add(new BarEntry(18f, 4));
                        entries1.add(new BarEntry(9f, 5));

                        BarDataSet dataset1 = new BarDataSet(entries1, "# of Calls");

                        ArrayList<String> labels1 = new ArrayList<String>();
                        labels1.add("January");
                        labels1.add("February");
                        labels1.add("March");
                        labels1.add("April");
                        labels1.add("May");
                        labels1.add("June");

        /* for create Grouped Bar chart
        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(4f, 0));
        group1.add(new BarEntry(8f, 1));
        group1.add(new BarEntry(6f, 2));
        group1.add(new BarEntry(12f, 3));
        group1.add(new BarEntry(18f, 4));
        group1.add(new BarEntry(9f, 5));

        ArrayList<BarEntry> group2 = new ArrayList<>();
        group2.add(new BarEntry(6f, 0));
        group2.add(new BarEntry(7f, 1));
        group2.add(new BarEntry(8f, 2));
        group2.add(new BarEntry(12f, 3));
        group2.add(new BarEntry(15f, 4));
        group2.add(new BarEntry(10f, 5));

        BarDataSet barDataSet1 = new BarDataSet(group1, "Group 1");
        //barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet2 = new BarDataSet(group2, "Group 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<BarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);
        dataset.add(barDataSet2);
        */

                        BarData data1 = new BarData(labels1, dataset1);
                        // dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
                        barChart.setData(data1);
                        barChart.setDescription("");
                        barChart.setNoDataText(""); // this is the top line
                        barChart.setNoDataTextDescription(""); // this is one line below the no-data-text
                        barChart.invalidate();
                        barChart.animateY(5000);
                        break;
                    case 1:
                        barChart.setVisibility(View.INVISIBLE);
                        pieChart.setVisibility(View.VISIBLE);
                        ArrayList<Entry> entries = new ArrayList<>();
                        entries.add(new Entry(4f, 0));
                        entries.add(new Entry(8f, 1));
                        entries.add(new Entry(6f, 2));
                        entries.add(new Entry(12f, 3));
                        entries.add(new Entry(18f, 4));
                        entries.add(new Entry(9f, 5));

                        PieDataSet dataset = new PieDataSet(entries, "# of Calls");

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add("January");
                        labels.add("February");
                        labels.add("March");
                        labels.add("April");
                        labels.add("May");
                        labels.add("June");

                        PieData data = new PieData(labels, dataset);
                        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
                        pieChart.setDescription("Description");
                        pieChart.setNoDataText(""); // this is the top line
                        pieChart.setNoDataTextDescription(""); // this is one line below the no-data-text
                        pieChart.invalidate();
                        pieChart.setData(data);

                        pieChart.animateY(5000);

                        pieChart.saveToGallery("/sd/mychart.jpg", 85); // 85 is the quality of the image
                        break;


                }
                //Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }

        });


    }

}
