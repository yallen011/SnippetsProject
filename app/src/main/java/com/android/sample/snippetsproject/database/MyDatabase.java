package com.android.sample.snippetsproject.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.android.sample.snippetsproject.dao.ProductDao;
import com.android.sample.snippetsproject.entity.Product;

import static android.R.attr.version;

/**
 * Created by Yvonne on 8/14/2017.
 *
 * Database for persisting Products using Singleton pattern
 */
@Database(version = 1, entities={Product.class})
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase INSTANCE;

    public static MyDatabase getDatabase(Context context){

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    MyDatabase.class,
                    "product_db").build();
        }
        return INSTANCE;
    }

    public abstract ProductDao productDao();

}
