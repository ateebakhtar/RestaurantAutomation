package com.example.admin.restaurantautomation;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public ArrayList<String> mNames = new ArrayList<String>();
    public ArrayList<String> mImageUrls= new ArrayList<String>();
    public ArrayList<String> xn= new ArrayList<String>();

    menuapater adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
       // adddata();
        final RecyclerView recyclerView=findViewById(R.id.recyclerView);


        db.collection("Menu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete( Task<QuerySnapshot> task) {
                        String x3= null,x1= null,x2 = null;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot x : task.getResult()) {

                                x3 = x.getString("url");
                                x2 = x.getString("name");
                                x1 = x.getString("price");
                                System.out.println(x1+x2+x3);
                                if(x1!= null && x3!= null && x2!= null)
                                {
                                    xn.add(x2);
                                    mNames.add(x1);
                                    mImageUrls.add(x3);
                                }
                                else
                                {
                                    System.out.println("NULLS");
                                }
                            }
                        } else {
                            System.out.println("Eorrrosr");
                        }
                        menuapater adapter = new menuapater( Menu.this,mImageUrls,mNames,xn);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(Menu.this));
                        System.out.println("this is a tryyy"+xn.isEmpty());

                    }
                });

    }
    void adddata()
    {
        menuinfo a = new menuinfo();
        a.insertdata("Mega Burger","450","https://i1.wp.com/hip2save.com/wp-content/uploads/2011/07/checkers.png?resize=304%2C227&strip=all","Buns,Chicken,Mayo,Cheese","Burgers","1");
        db.collection("Menu").add(a);

        a.insertdata("Crunch ","170 ","https://feenix.co.in/wp-content/uploads/2017/12/72ef796c-ef3c-4067-adef-f10549d5707c.png ","Buns,Chicken,Mayo,Cheese. ","Burger ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Beef Lover ","480 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5GczoJvjZeU8UjyRaEBLGD5ZESZ4lgdK7efsvWEH9UBwUMB-u ","Buns,Beed,Mayo,Cheese. ","Burger ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Cheese Delight ","430 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOzmHO7dQwlUEz5bJOz7SKwv1EWNs_SGtSYHZTuCr50__giQ1aHg ","Buns,Chicken,Mayo,Cheese. ","Burger ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Mushroom Madness ","430 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRptKQ7cCi_ujtJBfOuJf1nhNBuwXeN9ruknyVkaqkiLI0kahIv ","Buns,Chicken,Mayo,Cheese,Mushroom. ","Burger "," 1");
        db.collection("Menu").add(a);

        a.insertdata("Pizza Burger ","510 ","https://hips.hearstapps.com/del.h-cdn.co/assets/17/14/1491339557-ragu-chicken-pizza-burgers-pinterest-1.jpg ","Buns,Chicken,Mayo,Cheese,Mushroom,Green Chillies.  ","Burger ","1");
        db.collection("Menu").add(a);

        a.insertdata("Twister ","280 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJIIXQRRme7HS79ICOnpOOYCirYqsF00MAtXHvQ_bmBEFLEmZA ","Dough,Chicken,Mayo,Cheese. "," Burger","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Chicken Strips ","170 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSpFlSMXEqoaFBXX5aphPcV8fgtOFdsYXKgzfaL3n3pc__pASv ","Chicken,Flour. ","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Mozrella Sticks ","130 ","https://i.pinimg.com/originals/5a/d7/c7/5ad7c7082079609c33ae4a6bdd3e4f7c.jpg ","Cheese,Flour. ","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Peri Bites ","130 ","https://magazine.foodpanda.pk/wp-content/uploads/sites/13/2017/02/WhatsApp-Image-2017-02-22-at-10.29.15-AM-e1487747652499.jpeg ","Green Chillies,Cheese. ","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Load Fries ","130 ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmn1xwzL1Kz2m3YWYo0o3hHpCT_u3GE67qQRcs5gywXdTC7LYK ","Mayo,Potatoes. ","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Plain Fries ","90 ","https://www.seriouseats.com/2018/04/20180309-french-fries-vicky-wasik-15-1500x1125.jpg ","Potatoes. ","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Garlic Bread ","90 ","https://food.fnr.sndimg.com/content/dam/images/food/fullset/2015/5/28/2/TM1A14F_Garlic-Bread_s4x3.jpg.rend.hgtvcom.826.620.suffix/1433523400627.jpeg ","Dough ","Starters ","1 ");
        db.collection("Menu").add(a);

        a.insertdata("Wedges ","110 ","https://www.errenskitchen.com/wp-content/uploads/2014/05/Seasoned-Baked-Potato-Wedges4-2.jpg ","Mayo,Potatoes. ","Starters ","1 ");
        db.collection("Menu").add(a);

        db.collection("Menu").add(a);


    }
}
