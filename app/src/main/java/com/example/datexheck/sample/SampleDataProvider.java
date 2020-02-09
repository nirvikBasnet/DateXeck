package com.example.datexheck.sample;

import android.provider.ContactsContract;

import com.example.datexheck.entities.DataItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider {
    public static List<DataItem> dataItemList;
    public static Map<String, DataItem> dataItemMap;

    static{
        dataItemList=new ArrayList<>();
        dataItemMap = new HashMap<>();




        addItem(new DataItem(null,"Himalayan Curd", "2020/02/05" ,123456,1));
        addItem(new DataItem(null,"Skim Milk", "2020/02/05" ,423456,2));
        addItem(new DataItem(null,"Classic Espresso", "2020/02/05" ,129456,3));
        addItem(new DataItem(null,"Himalayan Curd", "2020/02/05" ,120456,4));
        addItem(new DataItem(null,"Himalayan Curd", "2020/02/05" ,5232456,5));
        addItem(new DataItem(null,"Himalayan Curd", "2020/02/05" ,123456,6));
        addItem(new DataItem(null,"Himalayan Curd", "2020/02/05" ,1555456,7));
        addItem(new DataItem(null,"Himalayan Curd", "2020/02/05" ,156456,1));
        addItem(new DataItem(null,"Himalayan Curd", "2020/02/05" ,5423456,2));
        addItem(new DataItem(null,"Himalayan Curd", "2020/02/05" ,12433456,3));


    }



    private static void addItem(DataItem item){
        dataItemList.add(item);
        dataItemMap.put(item.getItemId(),item);
    }



}

