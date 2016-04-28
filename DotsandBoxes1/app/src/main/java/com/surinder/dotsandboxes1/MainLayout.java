package com.surinder.dotsandboxes1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainLayout extends Activity implements change_face_of_player{

    ImageView iv,iv1,iv2,iv3;
    TextView tv1,tv2;
    ImageButton b;
    private List<setting> set = new ArrayList<setting>();
     PopupWindow pw;

    fragment_1 frag;
    fragment_2 fm3;
    RelativeLayout rl;
    int choose_color_player1=0,choose_color_player2=0;
    changecolor ch;
    LinearLayout ll;
    Bitmap bitmap;
    ProgressDialog pDialog;

    interface changecolor
    {
        public void changecolor1(String ib,int which_player);
    }



    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_layout);
        rl = (RelativeLayout) findViewById(R.id.harman);
        b = (ImageButton) findViewById(R.id.menuButton);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv1 = (ImageView) findViewById(R.id.imageView);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView3);
        tv1.setTextSize(30);
        tv1.setText(Html.fromHtml("<font color='#0000FF'>" + 0 + "</font>"));
        tv2.setTextSize(30);
        tv2.setText(Html.fromHtml("<font color='#0000FF'>" + 0 + "</font>"));
        //  iv.setBackgroundResource(000000);


        populatesettingList();


        pw = nav();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        frag = new fragment_1(3,3,270);
        ch=frag;
        fragmentTransaction.add(R.id.fragment1, frag);
        fragmentTransaction.commit();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Intent animActivity = new Intent(MainLayout.this,Activity2.class);
              //  startActivity(animActivity);
              //  overridePendingTransition(R.animator.enter, R.animator.exit);
                   pw.showAtLocation(v, 50, 400, 300);
           //     new LoadImage().execute("https://www.learn2crack.com/wp-content/uploads/2014/04/node-cover-720x340.png");
            }
        });

        rl.setOnTouchListener(new OnSwipeTouchListener(MainLayout.this) {
            public void onSwipeTop() {
                Toast.makeText(MainLayout.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(MainLayout.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Toast.makeText(MainLayout.this, "left", Toast.LENGTH_SHORT).show();
                Intent animActivity = new Intent(MainLayout.this,Activity2.class);
                startActivity(animActivity);
                overridePendingTransition(R.animator.enter, R.animator.exit);
              //  Toast.makeText(MainLayout.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(MainLayout.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void populatesettingList() {
        set.add(new setting(R.mipmap.new_game_ic_launcher, "New game"));
        set.add(new setting(R.mipmap.player1ic_launcher, "Player 1"));
        set.add(new setting(R.mipmap.player2ic_launcher, "Player 2"));
        set.add(new setting(R.mipmap.change_backgroundic_launcher, "Change background"));
        set.add(new setting(R.mipmap.change_coloric_launcher, "Change Color"));
        set.add(new setting(R.mipmap.pen_setting_ic_launcher, "Pen setting"));
       set.add(new setting(R.mipmap.setting_ic_launcher, "Settings"));
    }


    public PopupWindow nav() {
        PopupWindow pw1 = new PopupWindow(MainLayout.this);
        PopupWindow pw2 = new PopupWindow(MainLayout.this);
        ListView listViewDogs = new ListView(this);
        ArrayAdapter<setting> adapter = new myListAdapter();


        listViewDogs.setAdapter(adapter);
        listViewDogs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fm3 = new fragment_2(3);
                    ch=fm3;
                    fragmentTransaction.replace(R.id.fragment1, fm3, "NewFragmentTag");
                    //      fragmentTransaction.add(R.id.fragment1, fm3);
                    fragmentTransaction.commit();

                }

                if (position == 1) {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fm3 = new fragment_2(4);
                    ch=fm3;
                    fragmentTransaction.replace(R.id.fragment1, fm3, "NewFragmentTag");
                    //      fragmentTransaction.add(R.id.fragment1, fm3);
                    fragmentTransaction.commit();

                }



                if (position == 4) {
                     LayoutInflater inflater = (LayoutInflater) MainLayout.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View layout = inflater.inflate(R.layout.choose_color, (ViewGroup) findViewById(R.id.horizontal_color));

                  final PopupWindow pw1 = new PopupWindow(layout, 800, 500, true);
                    final  ImageButton v1 = (ImageButton) layout.findViewById(R.id.imageButton);
                    final  ImageButton v2 = (ImageButton) layout.findViewById(R.id.imageButton15);
                    final  ImageButton v3 = (ImageButton) layout.findViewById(R.id.imageButton16);
                    View v = inflater.inflate(R.layout.activity_main_layout, parent, false);

                    pw1.showAtLocation(v, Gravity.CENTER, 0, 0);

                    v2.setAlpha(127);
                    v3.setAlpha(127);
                    pw.dismiss();


                    v2.setOnClickListener(new View.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View v) {
                            v2.setAlpha(255);
                            v3.setAlpha(127);
                            choose_color_player1=1;
                            choose_color_player2=0;
                        }
                    });

                    v3.setOnClickListener(new View.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View v) {
                            v3.setAlpha(255);
                            v2.setAlpha(127);
                            choose_color_player1=0;
                            choose_color_player2=1;

                        }
                    });


                    v1.setOnClickListener(new View.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View v) {
                            if(choose_color_player1==1){
                               // changecolor ch = frag;
                                ch.changecolor1("black",1);
                                Toast.makeText(MainLayout.this, "nav", Toast.LENGTH_LONG).show();
                                pw1.dismiss();
                            }

                            if(choose_color_player2==1){
                            //    changecolor ch = frag;
                                ch.changecolor1("black",2);
                                Toast.makeText(MainLayout.this, "nav", Toast.LENGTH_LONG).show();
                                pw1.dismiss();
                            }

                            if(choose_color_player2==0 && choose_color_player1==0){
                                final Animation animation = new AlphaAnimation(1, 0);
                                animation.setDuration(500);
                                animation.setRepeatCount(2);
                                v2.startAnimation(animation);
                                v3.startAnimation(animation);
                            }


                            //     rl.getForeground().setAlpha(0);


                        }
                    });
               //     rl.getForeground().setAlpha( 220);
                }

      //      pw.setFocusable(true);


                if (position == 5) {
                    PopupWindow pw = new PopupWindow(MainLayout.this);
                    pw.setWidth(900);
                    pw.setHeight(590);
                    LayoutInflater inflater = (LayoutInflater) MainLayout.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View layout = getLayoutInflater().inflate(R.layout.pen_setting, parent, false);
                    View v = inflater.inflate(R.layout.activity_main_layout, parent, false);

                    pw.setContentView(layout);
                    pw.setFocusable(true);

                    pw.showAtLocation(v, 0, 50, 100);

                }

                if (position == 6) {

                    LayoutInflater inflater = (LayoutInflater) MainLayout.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View layout = getLayoutInflater().inflate(R.layout.grid_change, parent, false);
                    final PopupWindow pw1 = new PopupWindow(layout, 800, 500, true);
                    View v = inflater.inflate(R.layout.activity_main_layout, parent, false);
                    final EditText row = (EditText) layout.findViewById(R.id.editText2);
                    final EditText coloumn = (EditText) layout.findViewById(R.id.editText);
                    final Button b = (Button) layout.findViewById(R.id.button);
                    pw.dismiss();
                    pw1.setFocusable(true);
                    b.setOnClickListener(new View.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View v) {
                          String r=  row.getText().toString();
                            String c=  coloumn.getText().toString();
                            int i = Integer.parseInt(r);
                            int j = Integer.parseInt(c);
                            System.out.println("value of i is" +i);
                            System.out.println("value of j is" +j);
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                            frag = new fragment_1(i,j,150);
                            ch=frag;
                            fragmentTransaction.replace(R.id.fragment1, frag, "NewFragmentTag");
                            //      fragmentTransaction.add(R.id.fragment1, fm3);
                            fragmentTransaction.commit();
                            pw1.dismiss();
                        }
                    });
                    pw1.showAtLocation(v, 0, 50, 100);

                }


                if (position == 3) {
                    PopupWindow pw = new PopupWindow(MainLayout.this);
                    pw.setWidth(900);
                    pw.setHeight(590);
                    LayoutInflater inflater = (LayoutInflater) MainLayout.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View layout = getLayoutInflater().inflate(R.layout.background_setting, parent, false);
                    View v = inflater.inflate(R.layout.activity_main_layout, parent, false);
                    pw.setContentView(layout);
                    pw.setFocusable(true);
                    pw.showAtLocation(v, 0, 50, 100);
                }
            }
        });

        listViewDogs.setBackgroundColor(Color.rgb(250,237,227));
        listViewDogs.setDividerHeight(5);

        pw1.setFocusable(true);
        pw1.setWidth(650);
        pw1.setHeight(1000);
        pw1.setContentView(listViewDogs);
        return pw1;
    }


        private class myListAdapter extends ArrayAdapter<setting> {
        public myListAdapter() {
            super(MainLayout.this, R.layout.list_view, set);
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            View itemview = convertView;
            if (itemview == null) {
                itemview = getLayoutInflater().inflate(R.layout.list_view, parent, false);

            }

            setting current_setting = set.get(position);

            ImageView image_view = (ImageView) itemview.findViewById(R.id.imageView);
            image_view.setImageResource(current_setting.getIcon());
            image_view.setMaxWidth(80);
            image_view.setMaxHeight(80);
            TextView text = (TextView) itemview.findViewById(R.id.textView);
            text.setText(current_setting.getName());
            text.setMaxWidth(20);
            text.setMaxHeight(20);
            return itemview;
        }
        }

    View.OnClickListener cancel_button_click_listener = new View.OnClickListener() {
        public void onClick(View v) {
            pw.dismiss();

        }
    };

   @Override
    public void change_player1_face(int num){
      //  iv1.setBackgroundColor(000000);
       // iv1.setVisibility(View.GONE);
       if(num==1) {
           final Animation animation = new AlphaAnimation(1, 0);
           animation.setDuration(1000);
           animation.setRepeatCount(Animation.INFINITE);
           iv1.startAnimation(animation);
       }
       if(num==0){
           iv1.clearAnimation();
       }
   }

    @Override
    public void change_player2_face(int num){
        if(num==1) {
        final Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(1000);
        animation.setRepeatCount(Animation.INFINITE);
        iv2.startAnimation(animation);
    }
        if(num==0){
            iv2.clearAnimation();
        }
    }


    public void player1_score(int score1){
        tv1.setTextSize(30);
        tv1.setText(Html.fromHtml("<font color='#0000FF'>" + score1 + "</font>"));
    }


    public void player2_score(int score2){
        tv2.setTextSize(30);
        tv2.setText(Html.fromHtml( "<font color='#0000FF'>"+score2+"</font>"));
    }


    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainLayout.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();

        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if(image != null){
                iv2.setImageBitmap(image);
                pDialog.dismiss();

            }else{

                pDialog.dismiss();
                Toast.makeText(MainLayout.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

            }
        }
    }

}
