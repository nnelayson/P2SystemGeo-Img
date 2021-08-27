package com.jose.p2system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.jose.p2system.HomeAdapter.FeaturedAdapter;
import com.jose.p2system.HomeAdapter.FeaturedHelperClass;
import com.jose.p2system.HomeAdapter2.FeaturedAdapter2;
import com.jose.p2system.HomeAdapter2.FeaturedHelperClass2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    static final float END_SCALE = 0.7f;

  ///  RecyclerView featuredRecycler, featuredRecyler2;

  ///  private FeaturedAdapter2.FeaturedViewHolder2.RecyclerViewClickListener listener;
  ///  RecyclerView.Adapter adapter, adapter2;

    Button btndelro, btnbarbie, btnblack, btnghost;


    ImageView menuIcon;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout contentView;

    CardView card1,card2,card3,card4;
    Dialog mdialog;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    ///    featuredRecycler = findViewById(R.id.featured_recycler);
    ///    featuredRecyler2 = findViewById(R.id.featured_recycler2);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);


        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);


        btndelro = findViewById(R.id.btndelro);
        btnbarbie = findViewById(R.id.btnbarbie);
        btnblack = findViewById(R.id.btnblack);
        btnghost = findViewById(R.id.btnghost);


        btndelro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DelroActivity.class);
                startActivity(intent);

            }
        });

        btnbarbie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Barbie1Activity.class);
                startActivity(intent);

            }
        });

        btnghost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GhostActivity.class);
                startActivity(intent);
            }
        });

        btnblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Black1Activity.class);
                startActivity(intent);
            }
        });






        mdialog = new Dialog(this);






        card3.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                popupdialog();
            }
        });


        navigationDrawer();
    ///    featuredRecycler();
     ///   featuredRecyler2();

    }

    private void popupdialog() {
        mdialog.setContentView(R.layout.gcash);
        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView img = mdialog.findViewById(R.id.img);
        mdialog.show();
    }





 ///   private void featuredRecyler2() {
  ///      setOnclickListener();
   ///     featuredRecyler2.setHasFixedSize(true);
   ///     featuredRecyler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

  ///      ArrayList<FeaturedHelperClass2> featuredLocations2 = new ArrayList<>();

   ///     featuredLocations2.add(new FeaturedHelperClass2(R.drawable.delro, "Adopt DELRO", "Delro is well socialized with other canines, and has no glaring requirements or behavioral issues."));
    ///    featuredLocations2.add(new FeaturedHelperClass2(R.drawable.barbie, "Adopt TITA BARBIE", "Barbie needs to be a solo dog because she is very jealous and dominant..."));
    ///    featuredLocations2.add(new FeaturedHelperClass2(R.drawable.straydogs, "Adopt TITO BADUNK", "badunk is very friendly and energetic..."));
    ///    featuredLocations2.add(new FeaturedHelperClass2(R.drawable.black, "Adopt Little Black", "He is a shy type but he is very friendly..."));
    ///    featuredLocations2.add(new FeaturedHelperClass2(R.drawable.ghost, "Adopt one of our “GHOSTBUSTERS PUPPIES”", "When their momma dog was rescued, we didn’t..."));

     ///   adapter2 = new FeaturedAdapter2(featuredLocations2,listener);

    ///    featuredRecyler2.setAdapter(adapter2);
  ///  }

  ///  private void setOnclickListener() {
  ///      listener = new FeaturedAdapter2.FeaturedViewHolder2.RecyclerViewClickListener() {
  ///          @Override
   ///         public void onclick(View v, int position) {
    ///             Intent intent = new Intent(getApplicationContext(),DelroActivity.class);

    ///            startActivity(intent);
    ///           }
    ///       };
    ///  }


    private void navigationDrawer() { navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
           }});

       animateNavigationDrawer();



    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide( View drawerView, float slideOffset) {

                final float diffScaledOffset = slideOffset * (1 - END_SCALE);


                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleX(offsetScale);

                final float xoffset = drawerView.getWidth() * slideOffset;
                final float xoffsetDiff = contentView.getWidth()* diffScaledOffset / 2;
                final float xTransaction = xoffset - xoffsetDiff;
                contentView.setTranslationX(xTransaction);


            }

            @Override
            public void onDrawerOpened( View drawerView) {

            }

            @Override
            public void onDrawerClosed( View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }




    ///   private void featuredRecycler() {
    ///    featuredRecycler.setHasFixedSize(true);
    ///    featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    ///    ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

    ///    featuredLocations.add(new FeaturedHelperClass(R.drawable.cat, "Can I donate/surrender my pet to paws?", "PAWS does not condone pet, ..."));
    ///   featuredLocations.add(new FeaturedHelperClass(R.drawable.dog1, "Does PAWS rescue stray animals?", "We are not a government agency, ...."));
    ///   featuredLocations.add(new FeaturedHelperClass(R.drawable.ddog, "How do I report animal cruelty or neglect?", "Animal cruelty MUST be stopped on, ..."));
    ///   adapter = new FeaturedAdapter(featuredLocations);
    ///   featuredRecycler.setAdapter(adapter);
    ///   }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }



}


