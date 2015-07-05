package com.example.thinh.listview;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {
    String []conuntry={
            "China",
            "Vietnamese",
            "Korea",
            "Japan",
            "America"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lstView=getListView();
//        lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
       lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        conuntry=getResources().getStringArray(R.array.conuntry);
        setListAdapter(new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_checked,
                conuntry));
        Button bt= (Button)findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView lst= getListView();
                String str="You select listview: \n";
                for (int i=0;i<lst.getCount();i++){
                    if(lst.isItemChecked(i))
                        str+=lst.getItemAtPosition(i)+" \n";
                }
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();;

            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this,"You select item:"+conuntry[position],Toast.LENGTH_SHORT).show();
       // super.onListItemClick(l, v, position, id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
}
