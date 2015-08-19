package pbru.u.sukuma.easytraffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    //Explicit ประกาศตัวแปร
    private ListView trafficListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial Widget
        initialWidget();

        createListView();


    }//main method

    public void clickTest(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }

    private void createListView() {
        final String[] StrTitle = new String[20];
        StrTitle[0] = "ห้ามเลี้ยวซ้าย";
        StrTitle[1] = "ห้ามเลี้ยวขวา";
        StrTitle[2] = "ตรงไป";
        StrTitle[3] = "เลี้ยวซ้าย";
        StrTitle[4] = "เลี้ยวขวา";
        StrTitle[5] = "ออก";
        StrTitle[6] = "เข้า";
        StrTitle[7] = "ออก";
        StrTitle[8] = "หยุด";
        StrTitle[9] = "จำกัดความสูง";
        StrTitle[10] = "ทางแยก";
        StrTitle[11] = "ห้ามกลับรถ";
        StrTitle[12] = "ห้ามจอด";
        StrTitle[13] = "รถสวน";
        StrTitle[14] = "ห้ามแซง";
        StrTitle[15] = "เข้า";
        StrTitle[16] = "หยุดตรวจ";
        StrTitle[17] = "จำกัดความเร็ว";
        StrTitle[18] = "จำกัดความกว้าง";
        StrTitle[19] = "จำกัดความสูง";


        final int[] intImage = {R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03,
                R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06,
                R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09,
                R.drawable.traffic_10, R.drawable.traffic_11, R.drawable.traffic_12,
                R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
                R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18,
                R.drawable.traffic_19, R.drawable.traffic_20};

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, intImage, StrTitle);
        trafficListView.setAdapter(objMyAdapter);

        //active Lis
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //intent to detail

                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);

                objIntent.putExtra("Title", StrTitle[i]);
                objIntent.putExtra("Image", intImage[i]);
                objIntent.putExtra("Detail", i);


                startActivity(objIntent);


            }//event
        });

    }

    private void initialWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }   //main Method นี่คือ method หลัก



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
} //Main Class นี่คือ คลาสหลัก
