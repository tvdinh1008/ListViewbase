package com.example.listbase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items;
    ArrayAdapter<String> adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);

        items=new ArrayList<>();
        for(int i=0;i<20;i++)
        {
            items.add("item thu: "+i);
        }
        //sử dụng layout do android cung cấp 3 tham số.simple_list_item_1 tức mỗi item chỉ có 1 dòng thôi .simple_list_item_2 tức 2 trên 1 item
        //adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        /*sử dung layout do ta tự tạo
            res->layout->new-> layout resource file

            sử dụng 4 tham số
            do trong layout mk tạo có nhiều textview-> cấn chọn 1 cái để hiển thị
         */
        adapter=new ArrayAdapter<>(this,R.layout.layout_list,R.id.txtV2,items);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("TAG",items.get(position)+ " is selected");
            }
        });
        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.set(0,"change New Item 0");
                //nó sẽ cập nhât luôn nếu không thì ta phải lăn chuôt 1 lúc thì nó mới cập nhật lại
                adapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++)
                {
                    items.add("add item thu: "+i);
                }
                //nó sẽ cập nhât luôn nếu không thì ta phải lăn chuôt 1 lúc thì nó mới cập nhật lại
                adapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++)
                {
                    items.remove(0);
                }
                //nó sẽ cập nhât luôn nếu không thì ta phải lăn chuôt 1 lúc thì nó mới cập nhật lại
                adapter.notifyDataSetChanged();
            }
        });
        /*
       // MainActivity extends ListActivity
        setListAdapter(adapter);
         */
    }


    /*
    MainActivity extends ListActivity
    //position cho biết item thứ mấy đc nhấn:
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.v("TAG",items.get(position)+ " is selected");
    }

    */
}
