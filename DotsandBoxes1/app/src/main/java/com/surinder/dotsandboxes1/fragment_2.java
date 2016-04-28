package com.surinder.dotsandboxes1;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
/**
 * Created by surin on 2/8/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public  class  fragment_2 extends Fragment implements View.OnClickListener, MainLayout.changecolor {
    int x=0;
    int player1_color = Color.RED;
    int player2_color = Color.BLUE;
    ImageButton player1_array[] = new ImageButton[10];
    ImageButton player2_array[] = new ImageButton[10];
    int count_player1_array = 0;
    int count_player2_array = 0;
    ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7;
    ImageView iv1;
    int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0,k=0,l=0;
    Activity activity;
    View rootview;
    Bitmap productIndex = null;
    int player1_score=0,player2_score=0;
    ImageButton ib[][][] = new ImageButton[100][100][100];
    ImageView iv[][][] = new ImageView[100][100][100];
    ImageView iv_small[][] = new ImageView[100][100];
    LinearLayout ll[][] = new LinearLayout[100][100];
    LayoutParams params[][][] = new LayoutParams[100][100][100];

    LinearLayout mainlayout;

    int value[][] = new int[100][100];
    int flag1 = 0, flag2 = 0, flag3=0,flag4=0;
    int player_turn = 0;
  //  int player1_color = Color.GREEN;
  //  int Player2_color = Color.RED;
    Animation animation;
    int coloumns;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = activity;
    }

    public  fragment_2(int x){
        coloumns=x;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment2_layout, container, false);
        LinearLayout mainlayout =  (LinearLayout)rootview.findViewById(R.id.nav);



        int k = 1;
            LayoutParams param = new LayoutParams(25,25);
        LayoutParams param1 = new LayoutParams(25,25);
        LayoutParams param2 = new LayoutParams(25,25);
        LayoutParams param3 = new LayoutParams(25,25);
        LayoutParams param4 = new LayoutParams(25,25);
        LayoutParams param5 = new LayoutParams(25,25);
            while (k < 4) {



                if (k % 2==0) {
                    int i = 0;
                     flag3 = 0;
                     if(flag3==0){
                    //   params[i] = new LayoutParams(25, 100);
                         i=0;
                         ll[k][i] = new LinearLayout(getActivity());
                         ll[k][i].setOrientation(LinearLayout.HORIZONTAL);
                    int flag = 0;
                    for (int j = 0; j < 6; j++) {

                        if (flag == 0) {
                            iv[k][i][j] = new ImageView(getActivity());
                            iv[k][i][j].setLayoutParams(param2);
                            //          param.topMargin = 120;
                            param2.leftMargin = 50;
                            iv[k][i][j].setBackgroundResource(R.drawable.circle);

                            ll[k][i].addView(iv[k][i][j]);

                            ib[k][i][j] = new ImageButton(getActivity());
                            params[k][i][j] = new LayoutParams(25, 150);
                            //    LayoutParams params[i] = new LayoutParams(100, 25);
                            params[k][i][j].leftMargin = 50;
                            //  params[i][j].topMargin = 10;
                            ib[k][i][j].setLayoutParams(params[k][i][j]);
                            ib[k][i][j].setRotation(130);
                            ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                            ll[k][i].addView(ib[k][i][j]);
                            //     ib[i][j].setLayoutParams(params1);
                            final int y = i;
                            final int z = j;
                            final int o = k;
                            ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (value[y][z] == 0) {
                                        player_turn++;
                                        player(ib[o][y][z], player_turn);
                                    }
                                    value[y][z] = 1;
                                    System.out.println("navpreet");
                                }
                            });

                            flag = 1;
                            //    flag2=1;
                            //  flag1=1;
                        } else {
                            if (flag == 1) {
                                iv[k][i][j] = new ImageView(getActivity());
                                iv[k][i][j].setLayoutParams(param3);
                                param3.leftMargin = 50;
                                param3.topMargin = 120;
                                iv[k][i][j].setBackgroundResource(R.drawable.circle);

                                ll[k][i].addView(iv[k][i][j]);

                                ib[k][i][j] = new ImageButton(getActivity());
                                params[k][i][j] = new LayoutParams(25, 150);
                                //     LayoutParams params2 = new LayoutParams(100, 100);
                                params[k][i][j].leftMargin = 50;
                                //  params[i][j].topMargin = 10;

                                ib[k][i][j].setLayoutParams(params[k][i][j]);
                                ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                                ib[k][i][j].setRotation(-130);
                                final int y = i;
                                final int z = j;
                                final int o = k;
                                ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        if (value[y][z] == 0) {
                                            player_turn++;
                                            player(ib[o][y][z], player_turn);
                                        }
                                        value[y][z] = 1;
                                        System.out.println("navpreet");
                                    }
                                });
                                flag = 0;
                                ll[k][i].addView(ib[k][i][j]);

                            }
                        }

                    }
                         mainlayout.addView(ll[k][i]);
                         flag3 = 1;
                }
                    if(flag3==1){
                        int flag = 0;
                        i++;
                        ll[k][i] = new LinearLayout(getActivity());
                        ll[k][i].setOrientation(LinearLayout.HORIZONTAL);
                        for (int j = 0; j < 3; j++) {
                            if (flag == 0) {
                                ib[k][i][j] = new ImageButton(getActivity());
                                params[k][i][j] = new LayoutParams(25, 150);

                                params[k][i][j].leftMargin = 200;
                                //    params[i][j].topMargin = 10;
                                ib[k][i][j].setLayoutParams(params[k][i][j]);
                                ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                                final int o = k;
                                final int y = i;
                                final int z = j;
                                ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        if (value[y][z] == 0) {
                                            player_turn++;
                                            player(ib[o][y][z], player_turn);
                                        }
                                        value[y][z] = 1;
                                        System.out.println("navpreet");
                                    }
                                });
                                ll[k][i].addView(ib[k][i][j]);
                                flag = 1;
                                //      flag2=1;

                            } else {
                                ib[k][i][j] = new ImageButton(getActivity());
                                params[k][i][j] = new LayoutParams(25, 150);
                                //      params[i][j] = new LayoutParams(100, 25);
                                //     params[i][j].topMargin = 10;
                                params[k][i][j].leftMargin = 275;
                                ib[k][i][j].setLayoutParams(params[k][i][j]);
                                ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                                final int o = k;
                                final int y = i;
                                final int z = j;
                                ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        if (value[y][z] == 0) {
                                            player_turn++;
                                            player(ib[o][y][z], player_turn);
                                        }
                                        value[y][z] = 1;
                                        System.out.println("navpreet");
                                    }
                                });
                                //  flag2 = 1;
                                ll[k][i].addView(ib[k][i][j]);

                            }
                        }
                        mainlayout.addView(ll[k][i]);

                    }
                }





                else if (k % 2 == 1) {
                     flag4 = 0;

                     if(flag4==0){
                         i =0;
                         ll[k][i] = new LinearLayout(getActivity());
                         ll[k][i].setOrientation(LinearLayout.HORIZONTAL);
                    //   params[i] = new LayoutParams(25, 100);

                    int flag = 0;
                    for (int j = 0; j < 6; j++) {

                        if (flag == 0) {
                            iv[k][i][j] = new ImageView(getActivity());
                            iv[k][i][j].setLayoutParams(param);
                            param.topMargin = 120;
                            param.leftMargin = 50;
                            iv[k][i][j].setBackgroundResource(R.drawable.circle);

                            ll[k][i].addView(iv[k][i][j]);

                            ib[k][i][j] = new ImageButton(getActivity());
                            params[k][i][j] = new LayoutParams(25, 150);
                            //    LayoutParams params[i] = new LayoutParams(100, 25);
                            params[k][i][j].leftMargin = 50;
                            //  params[i][j].topMargin = 10;
                            ib[k][i][j].setLayoutParams(params[k][i][j]);
                            ib[k][i][j].setRotation(50);
                            ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                            ll[k][i].addView(ib[k][i][j]);
                            //     ib[i][j].setLayoutParams(params1);
                            final int y = i;
                            final int z = j;
                            final int o = k;
                            ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (value[y][z] == 0) {
                                        player_turn++;
                                        player(ib[o][y][z], player_turn);
                                    }
                                    value[y][z] = 1;
                                    System.out.println("navpreet");
                                }
                            });

                            flag = 1;
                            //    flag2=1;
                            //  flag1=1;
                        } else {
                            if (flag == 1) {
                                iv[k][i][j] = new ImageView(getActivity());
                                iv[k][i][j].setLayoutParams(param1);
                                param1.leftMargin = 50;
                                iv[k][i][j].setBackgroundResource(R.drawable.circle);

                                ll[k][i].addView(iv[k][i][j]);

                                ib[k][i][j] = new ImageButton(getActivity());
                                params[k][i][j] = new LayoutParams(25, 150);
                                //     LayoutParams params2 = new LayoutParams(100, 100);
                                params[k][i][j].leftMargin = 50;
                                //  params[i][j].topMargin = 10;

                                ib[k][i][j].setLayoutParams(params[k][i][j]);
                                ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                                ib[k][i][j].setRotation(-50);
                                final int y = i;
                                final int z = j;
                                final int o = k;
                                ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        if (value[y][z] == 0) {
                                            player_turn++;
                                            player(ib[o][y][z], player_turn);
                                        }
                                        value[y][z] = 1;
                                        System.out.println("navpreet");
                                    }
                                });
                                flag = 0;
                                ll[k][i].addView(ib[k][i][j]);

                            }
                        }
                    }
                         mainlayout.addView(ll[k][i]);
                    flag4 = 1;
                }

                     if(flag4==1) {
                         i++;
                         ll[k][i] = new LinearLayout(getActivity());
                         ll[k][i].setOrientation(LinearLayout.HORIZONTAL);
                         int flag = 0;
                         for (int j = 0; j < 4; j++) {
                             if (flag == 0) {
                                 ib[k][i][j] = new ImageButton(getActivity());
                                 params[k][i][j] = new LayoutParams(25, 150);

                                 params[k][i][j].leftMargin = 50;
                                 //    params[i][j].topMargin = 10;
                                 ib[k][i][j].setLayoutParams(params[k][i][j]);
                                 ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                                 final int o = k;
                                 final int y = i;
                                 final int z = j;
                                 ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {

                                         if (value[y][z] == 0) {
                                             player_turn++;
                                             player(ib[o][y][z], player_turn);
                                         }
                                         value[y][z] = 1;
                                         System.out.println("navpreet");
                                     }
                                 });
                                 ll[k][i].addView(ib[k][i][j]);
                                 flag = 1;
                                 //      flag2=1;

                             } else {
                                 ib[k][i][j] = new ImageButton(getActivity());
                                 params[k][i][j] = new LayoutParams(25, 150);
                                 //      params[i][j] = new LayoutParams(100, 25);
                                 //     params[i][j].topMargin = 10;
                                 params[k][i][j].leftMargin = 270;
                                 ib[k][i][j].setLayoutParams(params[k][i][j]);
                                 ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                                 final int o = k;
                                 final int y = i;
                                 final int z = j;
                                 ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {

                                         if (value[y][z] == 0) {
                                             player_turn++;
                                             player(ib[o][y][z], player_turn);
                                         }
                                         value[y][z] = 1;
                                         System.out.println("navpreet");
                                     }
                                 });
                                 //  flag2 = 1;
                                 ll[k][i].addView(ib[k][i][j]);

                             }
                         }
                         mainlayout.addView(ll[k][i]);

                     }
                }






              //  mainlayout.addView(ll[k][i]);
                k++;
            }

        if(k%2==0){

            i=0;
            ll[k][i] = new LinearLayout(getActivity());
            ll[k][i].setOrientation(LinearLayout.HORIZONTAL);
            int flag = 0;
            for (int j = 0; j < 6; j++) {

                if (flag == 0) {
                    iv[k][i][j] = new ImageView(getActivity());
                    iv[k][i][j].setLayoutParams(param2);
                    //          param.topMargin = 120;
                    param2.leftMargin = 50;
                    iv[k][i][j].setBackgroundResource(R.drawable.circle);

                    ll[k][i].addView(iv[k][i][j]);

                    ib[k][i][j] = new ImageButton(getActivity());
                    params[k][i][j] = new LayoutParams(25, 150);
                    //    LayoutParams params[i] = new LayoutParams(100, 25);
                    params[k][i][j].leftMargin = 50;
                    //  params[i][j].topMargin = 10;
                    ib[k][i][j].setLayoutParams(params[k][i][j]);
                    ib[k][i][j].setRotation(130);
                    ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                    ll[k][i].addView(ib[k][i][j]);
                    //     ib[i][j].setLayoutParams(params1);
                    final int y = i;
                    final int z = j;
                    final int o = k;
                    ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (value[y][z] == 0) {
                                player_turn++;
                                player(ib[o][y][z], player_turn);
                            }
                            value[y][z] = 1;
                            System.out.println("navpreet");
                        }
                    });

                    flag = 1;
                    //    flag2=1;
                    //  flag1=1;
                } else {
                    if (flag == 1) {
                        iv[k][i][j] = new ImageView(getActivity());
                        iv[k][i][j].setLayoutParams(param3);
                        param3.leftMargin = 50;
                        param3.topMargin = 120;
                        iv[k][i][j].setBackgroundResource(R.drawable.circle);

                        ll[k][i].addView(iv[k][i][j]);

                        ib[k][i][j] = new ImageButton(getActivity());
                        params[k][i][j] = new LayoutParams(25, 150);
                        //     LayoutParams params2 = new LayoutParams(100, 100);
                        params[k][i][j].leftMargin = 50;
                        //  params[i][j].topMargin = 10;

                        ib[k][i][j].setLayoutParams(params[k][i][j]);
                        ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                        ib[k][i][j].setRotation(-130);
                        final int y = i;
                        final int z = j;
                        final int o = k;
                        ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (value[y][z] == 0) {
                                    player_turn++;
                                    player(ib[o][y][z], player_turn);
                                }
                                value[y][z] = 1;
                                System.out.println("navpreet");
                            }
                        });
                        flag = 0;
                        ll[k][i].addView(ib[k][i][j]);

                    }
                }

            }
            mainlayout.addView(ll[k][i]);

            }

        if(k%2==1){
            i=0;
            ll[k][i] = new LinearLayout(getActivity());
            ll[k][i].setOrientation(LinearLayout.HORIZONTAL);
            int flag = 0;
            for (int j = 0; j < 3; j++) {

                if (flag == 0) {
                    iv[k][i][j] = new ImageView(getActivity());
                    iv[k][i][j].setLayoutParams(param4);
                    //          param.topMargin = 120;
                    param4.leftMargin = 200;
                    iv[k][i][j].setBackgroundResource(R.drawable.circle);

                    ll[k][i].addView(iv[k][i][j]);

                    ib[k][i][j] = new ImageButton(getActivity());
                    params[k][i][j] = new LayoutParams(25, 150);
                    //    LayoutParams params[i] = new LayoutParams(100, 25);
                    params[k][i][j].leftMargin = 50;
                    //  params[i][j].topMargin = 10;
                    ib[k][i][j].setLayoutParams(params[k][i][j]);
                    ib[k][i][j].setRotation(130);
                    ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                    ll[k][i].addView(ib[k][i][j]);
                    //     ib[i][j].setLayoutParams(params1);
                    final int y = i;
                    final int z = j;
                    final int o = k;
                    ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (value[y][z] == 0) {
                                player_turn++;
                                player(ib[o][y][z], player_turn);
                            }
                            value[y][z] = 1;
                            System.out.println("navpreet");
                        }
                    });

                    flag = 1;
                    //    flag2=1;
                    //  flag1=1;
                } else {
                    if (flag == 1) {
                        iv[k][i][j] = new ImageView(getActivity());
                        iv[k][i][j].setLayoutParams(param5);
                        param5.leftMargin = 100;
                        param5.topMargin = 120;
                        iv[k][i][j].setBackgroundResource(R.drawable.circle);

                        ll[k][i].addView(iv[k][i][j]);

                        ib[k][i][j] = new ImageButton(getActivity());
                        params[k][i][j] = new LayoutParams(25, 150);
                        //     LayoutParams params2 = new LayoutParams(100, 100);
                        params[k][i][j].leftMargin = 50;
                        //  params[i][j].topMargin = 10;

                        ib[k][i][j].setLayoutParams(params[k][i][j]);
                        ib[k][i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                        ib[k][i][j].setRotation(-130);
                        final int y = i;
                        final int z = j;
                        final int o = k;
                        ib[k][i][j].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (value[y][z] == 0) {
                                    player_turn++;
                                    player(ib[o][y][z], player_turn);
                                }
                                value[y][z] = 1;
                                System.out.println("navpreet");
                            }
                        });
                        flag = 0;
                        ll[k][i].addView(ib[k][i][j]);

                    }
                }

            }
            mainlayout.addView(ll[k][i]);
        }


        return rootview;
    }

    public void player(ImageButton ib,int plr_turn){
        if(plr_turn%2==1){
            ib.setBackgroundColor(player1_color);


        }
        else{
            ib.setBackgroundColor(player2_color);
        }
    }
    @Override
    public void onClick(View v) {

    }



    @Override
    public void changecolor1(String ib,int which_player) {



        //  ImageButton p1 = (ImageButton) getView().findViewById(R.id.imageButton3);
        if(which_player==1) {
            for (int i = 0; i < count_player1_array; i++) {
                player1_color = Color.BLACK;
                player1_array[i].setBackgroundColor(player1_color);
            }
        }

        if(which_player==2) {
            for (int i = 0; i < count_player2_array; i++) {
                player2_color = Color.GREEN;
                player2_array[i].setBackgroundColor(player2_color);
            }
        }
        System.out.println(ib);
    }


}
