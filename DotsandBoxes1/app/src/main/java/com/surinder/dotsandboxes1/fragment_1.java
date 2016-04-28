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
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by surin on 2/8/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public  class  fragment_1 extends Fragment implements View.OnClickListener, MainLayout.changecolor {
    int x = 0;
    int player1_color = Color.GRAY;
    int player2_color = Color.BLUE;
    ImageButton player1_array[] = new ImageButton[100];
    ImageButton player2_array[] = new ImageButton[100];
    int count_player1_array = 0;
    int count_player2_array = 0;
    ImageButton ib1, ib2, ib3, ib4, ib5, ib6, ib7;
    ImageView iv1;

    Activity activity;
    View rootview;
    Bitmap productIndex = null;
    int player1_score = 0, player2_score = 0;
    ImageButton ib[][] = new ImageButton[100][100];
    TextView iv[][] = new TextView[100][100];
    ImageView iv_small[][] = new ImageView[100][100];
    LinearLayout ll[] = new LinearLayout[100];
    LinearLayout mainlayout;
    AbsListView.LayoutParams parms1, parm2, parm3;
    int value[][] = new int[100][100];
    int boxes[][] = new int[100][100];
    int player_turn = 0;
    int double_check;
    //  int player1_color=Color.GREEN;
   // int Player2_color = Color.RED;
    int coloumns;
    int rows;
    int width ;
    int height = 25;


   public fragment_1(int x,int y,int z){
       rows=x;
       coloumns=y;
       width = z;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment1_layout, container, false);
        LinearLayout mainlayout = (LinearLayout) rootview.findViewById(R.id.nav);
        ((MainLayout) activity).change_player1_face(1);
        ((MainLayout) activity).change_player2_face(0);
        ((MainLayout) activity).player1_score(0);
        ((MainLayout) activity).player2_score(0);
        for(int i=0; i <10; i++){
            for(int j=0; j <10; j++) {
                boxes[i][j] = 0;
            }
        }
    //    ((MainLayout) activity).change_player1_face(1);
        for (int i = 0; i < ((coloumns*2)+1); i++) {
            int x = 0;
            ll[i] = new LinearLayout(getActivity());
            ll[i].setOrientation(LinearLayout.HORIZONTAL);
            AbsListView.LayoutParams parms1 = new AbsListView.LayoutParams(25, 25);
            AbsListView.LayoutParams parms2 = new AbsListView.LayoutParams(width, height);
            AbsListView.LayoutParams parms3 = new AbsListView.LayoutParams(height, width);
            AbsListView.LayoutParams parms4 = new AbsListView.LayoutParams(width, width);
            if (i % 2 == 0) {
                for (int j = 0; j <rows; j++) {

                    iv_small[i][j] = new ImageView(getActivity());
                    iv_small[i][j].setLayoutParams(parms1);
                    iv_small[i][j].setBackgroundResource(R.drawable.circle);

               //     iv_small[i][j].setBackgroundColor(Color.BLACK);
                    ib[i][j] = new ImageButton(getActivity());
                    ib[i][j].setLayoutParams(parms2);

               //     ib[i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
               //     ib[i][j].setBackgroundResource();
                    final int y = i;
                    final int z = j;
                    value[y][z] =0;
                    ib[i][j].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (value[y][z] == 0) {
                                player_turn++;
                                player(ib[y][z], player_turn);
                                value[y][z] = 1;
                                checkbox();
                            }

                            System.out.println("navpreet");
                        }
                    });
                    value[i][j] = 0;
                    //    ib[i][j].setOnClickListener(MainActivity.this);
                    //    final int y=i;
                    //     final int z=j;

                    //        ib[i][j].setBackgroundColor(Color.GREEN);
                    ll[i].addView(iv_small[i][j]);
                    ll[i].addView(ib[i][j]);
                    x = j;
                }
                x++;
                iv_small[i][x] = new ImageView(getActivity());
                iv_small[i][x].setLayoutParams(parms1);
                iv_small[i][x].setBackgroundResource(R.drawable.circle);
              //  iv_small[i][x].setBackgroundColor(Color.BLACK);
                ll[i].addView(iv_small[i][x]);
            }

            if (i % 2 == 1) {
                for (int j = 0; j <rows; j++) {
                    ib[i][j] = new ImageButton(getActivity());
                    ib[i][j].setLayoutParams(parms3);
              //      ib[i][j].setBackgroundResource(R.drawable.tags_rounded_corners);
                    value[i][j] = 0;
                    final int y = i;
                    final int z = j;
                    value[y][z] =0;
                    ib[i][j].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (value[y][z] == 0) {
                                player_turn++;
                                player(ib[y][z], player_turn);
                                value[y][z] = 1;
                                checkbox();
                            }

                            System.out.println("nav");
                        }
                    });

                    iv[i][j] = new TextView(getActivity());
                    iv[i][j].setLayoutParams(parms4);
                  //  iv[i][j].setBackgroundResource(R.drawable.circle);
                    ll[i].addView(ib[i][j]);
                    ll[i].addView(iv[i][j]);
                    x = j;
                }
                x++;
                ib[i][x] = new ImageButton(getActivity());
                ib[i][x].setLayoutParams(parms3);
             //   ib[i][x].setBackgroundResource(R.drawable.tags_rounded_corners);
                value[i][x] = 0;
                final int y = i;
                final int z = x;
                value[y][z] =0;
                ib[i][x].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (value[y][z] == 0) {
                            player_turn++;
                            player(ib[y][z], player_turn);
                            value[y][z] = 1;
                            checkbox();
                        }

                        System.out.println("nav");
                    }
                });
                ll[i].addView(ib[i][x]);
            }

            mainlayout.addView(ll[i]);

        }
        return rootview;
    }


    public void player(ImageButton ib, int plr_turn) {
        if (plr_turn % 2 == 1) {
       //    activity.change_player1_face(1);
            try{
                ((MainLayout) activity).change_player1_face(0);
                ((MainLayout) activity).change_player2_face(1);
            }catch (ClassCastException cce){
            }
            player1_array[count_player1_array++]=ib;
            ib.setBackgroundColor(player1_color);
        } else {
            try{
                ((MainLayout) activity).change_player1_face(1);
                ((MainLayout) activity).change_player2_face(0);
            }catch (ClassCastException cce){
            }
            player2_array[count_player2_array++]=ib;
            ib.setBackgroundColor(player2_color);
        }
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void changecolor1(String ib, int which_player) {


        //  ImageButton p1 = (ImageButton) getView().findViewById(R.id.imageButton3);
        if (which_player == 1) {
            for (int i = 0; i < count_player1_array; i++) {
                player1_color = Color.BLACK;
                player1_array[i].setBackgroundColor(player1_color);
            }
        }

        if (which_player == 2) {
            for (int i = 0; i < count_player2_array; i++) {
                player2_color = Color.YELLOW;
                player2_array[i].setBackgroundColor(player2_color);
            }
        }
        System.out.println(ib);
    }

public  void checkbox() {
        double_check=0;
    ///////////////////////////////////  first row  ///////////////////////////////////////////////////////////////////////

    if ( value[0][0]==1 && value[1][1]==1&&value[1][0]==1 &&value[2][0]==1) {
        if(double_check==0){
        if (boxes[0][0]==0) {
            fillbox(iv[1][0]);
            double_check++;
        }
        }
        else{
            double_fill_box(iv[1][0]);
            }
        boxes[0][0]=1;
        }



    if ( value[1][1]==1 && value[2][1]==1&&value[1][2]==1 &&value[0][1]==1) {
        if (double_check==0) {
            if (boxes[0][1] == 0) {
                fillbox(iv[1][1]);
                double_check++;
            }
        }
        else{
            double_fill_box(iv[1][1]);
        }
            boxes[0][1] = 1;

    }

    if ( value[1][2]==1 && value[2][2]==1&&value[1][3]==1 &&value[0][2]==1) {
        if(double_check==0) {
            if (boxes[0][2] == 0) {
                fillbox(iv[1][2]);
                double_check++;
            }
        }else{
            double_fill_box(iv[1][2]);
        }
        boxes[0][2]=1;
    }

    if ( value[1][3]==1 && value[2][3]==1&&value[1][4]==1 &&value[0][3]==1) {
        if(double_check==0) {
            if (boxes[0][3] == 0) {
                fillbox(iv[1][3]);
                double_check++;
            }
        }else{
            double_fill_box(iv[1][3]);
        }
        boxes[0][3]=1;
    }

    if ( value[1][4]==1 && value[2][4]==1&&value[1][5]==1 &&value[0][4]==1) {
        if (boxes[0][4]==0) {
            fillbox(iv[1][4]);
        }
        boxes[0][4]=1;
    }

    ///////////////////////////////////////    second row     ////////////////////////////////////////////////////////////

    if ( value[3][0]==1 && value[4][0]==1&&value[3][1]==1 &&value[2][0]==1) {
        if (boxes[1][0]==0) {
            fillbox(iv[3][0]);
        }
        boxes[1][0]=1;
    }

    if ( value[3][1]==1 && value[4][1]==1&&value[3][2]==1 &&value[2][1]==1) {
        if (boxes[1][1]==0) {
            fillbox(iv[3][1]);
        }
        boxes[1][1]=1;
    }

    if ( value[3][2]==1 && value[4][2]==1&&value[3][3]==1 &&value[2][2]==1) {
        if (boxes[1][2]==0) {
            fillbox(iv[3][2]);
        }
        boxes[1][2]=1;
    }

    if ( value[3][3]==1 && value[4][3]==1&&value[3][4]==1 &&value[2][3]==1) {
        if (boxes[1][3]==0) {
            fillbox(iv[3][3]);
        }
        boxes[1][3]=1;
    }

    if ( value[3][4]==1 && value[4][4]==1&&value[3][5]==1 &&value[2][4]==1) {
        if (boxes[0][4]==0) {
            fillbox(iv[1][4]);
        }
        boxes[1][4]=1;
    }

    //////////////////////////////////   third row   //////////////////////////////////////////////////////////////////

    if ( value[5][0]==1 && value[6][0]==1&&value[5][1]==1 &&value[4][0]==1) {
        if (boxes[2][0]==0) {
            fillbox(iv[5][0]);
        }
        boxes[2][0]=1;
    }

    if ( value[5][1]==1 && value[6][1]==1&&value[5][2]==1 &&value[4][1]==1) {
        if (boxes[2][1]==0) {
            fillbox(iv[5][1]);
        }
        boxes[2][1]=1;
    }

    if ( value[5][2]==1 && value[6][2]==1&&value[5][3]==1 &&value[4][2]==1) {
        if (boxes[2][2]==0) {
            fillbox(iv[5][2]);
        }
        boxes[2][2]=1;
    }

    if ( value[5][3]==1 && value[6][3]==1&&value[5][4]==1 &&value[4][3]==1) {
        if (boxes[2][3]==0) {
            fillbox(iv[5][3]);
        }
        boxes[2][3]=1;
    }

    if ( value[5][4]==1 && value[6][4]==1&&value[5][5]==1 &&value[4][4]==1) {
        if (boxes[2][4]==0) {
            fillbox(iv[5][4]);
        }
        boxes[2][4]=1;
    }

    //////////////////////////////////   fourth box   /////////////////////////////////////////////////////////

    if ( value[7][0]==1 && value[8][0]==1&&value[7][1]==1 &&value[6][0]==1) {
        if (boxes[3][0]==0) {
            fillbox(iv[7][0]);
        }
        boxes[3][0]=1;
    }

    if ( value[7][1]==1 && value[8][1]==1&&value[7][2]==1 &&value[6][1]==1) {
        if (boxes[3][1]==0) {
            fillbox(iv[7][1]);
        }
        boxes[3][1]=1;
    }

    if ( value[7][2]==1 && value[8][2]==1&&value[7][3]==1 &&value[6][2]==1) {
        if (boxes[3][2]==0) {
            fillbox(iv[7][2]);
        }
        boxes[3][2]=1;
    }

    if ( value[7][3]==1 && value[8][3]==1&&value[7][4]==1 &&value[6][3]==1) {
        if (boxes[3][3]==0) {
            fillbox(iv[7][3]);
        }
        boxes[3][3]=1;
    }

    if ( value[7][4]==1 && value[8][4]==1&&value[7][5]==1 &&value[6][4]==1) {
        if (boxes[3][4]==0) {
            fillbox(iv[7][4]);
        }
        boxes[3][4]=1;
    }

    ////////////////////////////////////   fifth  box    //////////////////////////////////////////////////////////////

    if ( value[9][0]==1 && value[10][0]==1&&value[9][1]==1 &&value[8][0]==1) {
        if (boxes[4][0]==0) {
            fillbox(iv[9][0]);
        }
        boxes[4][0]=1;
    }

    if ( value[9][1]==1 && value[10][1]==1&&value[9][2]==1 &&value[8][1]==1) {
        if (boxes[4][1]==0) {
            fillbox(iv[9][1]);
        }
        boxes[4][1]=1;
    }

    if ( value[9][2]==1 && value[10][2]==1&&value[9][3]==1 &&value[8][2]==1) {
        if (boxes[4][2]==0) {
            fillbox(iv[9][2]);
        }
        boxes[4][2]=1;
    }

    if ( value[9][3]==1 && value[10][3]==1&&value[9][4]==1 &&value[8][3]==1) {
        if (boxes[4][3]==0) {
            fillbox(iv[9][3]);
        }
        boxes[4][3]=1;
    }

    if ( value[9][4]==1 && value[10][4]==1&&value[9][5]==1 &&value[8][4]==1) {
        if (boxes[4][4]==0) {
            fillbox(iv[9][4]);
        }
        boxes[4][4]=1;
    }

    ////////////////////////////////////   sixth  box    //////////////////////////////////////////////////////////////

    if ( value[11][0]==1 && value[12][0]==1&&value[11][1]==1 &&value[10][0]==1) {
        if (boxes[5][0]==0) {
            fillbox(iv[11][0]);
        }
        boxes[5][0]=1;
    }

    if ( value[11][1]==1 && value[12][1]==1&&value[11][2]==1 &&value[10][1]==1) {
        if (boxes[5][1]==0) {
            fillbox(iv[11][1]);
        }
        boxes[5][1]=1;
    }

    if ( value[11][2]==1 && value[12][2]==1&&value[11][3]==1 &&value[10][2]==1) {
        if (boxes[5][2]==0) {
            fillbox(iv[11][2]);
        }
        boxes[5][2]=1;
    }

    if ( value[11][3]==1 && value[12][3]==1&&value[11][4]==1 &&value[10][3]==1) {
        if (boxes[5][3]==0) {
            fillbox(iv[11][3]);
        }
        boxes[5][3]=1;
    }

    if ( value[11][4]==1 && value[12][4]==1&&value[11][5]==1 &&value[10][4]==1) {
        if (boxes[5][4]==0) {
            fillbox(iv[11][4]);
        }
        boxes[5][4]=1;
    }

    //////////////////////////////////////////   seventh    box   //////////////////////////////////////////////////////////

    if ( value[13][0]==1 && value[14][0]==1&&value[13][1]==1 &&value[12][0]==1) {
        if (boxes[6][0]==0) {
            fillbox(iv[13][0]);
        }
        boxes[6][0]=1;
    }

    if ( value[13][1]==1 && value[14][1]==1&&value[13][2]==1 &&value[12][1]==1) {
        if (boxes[6][1]==0) {
            fillbox(iv[13][1]);
        }
        boxes[6][1]=1;
    }

    if ( value[13][2]==1 && value[14][2]==1&&value[13][3]==1 &&value[12][2]==1) {
        if (boxes[6][2]==0) {
            fillbox(iv[13][2]);
        }
        boxes[6][2]=1;
    }

    if ( value[13][3]==1 && value[14][3]==1&&value[13][4]==1 &&value[12][3]==1) {
        if (boxes[6][3]==0) {
            fillbox(iv[13][3]);
        }
        boxes[6][3]=1;
    }

    if ( value[13][4]==1 && value[14][4]==1&&value[13][5]==1 &&value[12][4]==1) {
        if (boxes[6][4]==0) {
            fillbox(iv[13][4]);
        }
        boxes[6][4]=1;
    }

who_win();

}

    public void fillbox(TextView ib){
        if (player_turn % 2 == 1) {
            ib.setBackgroundColor(Color.GREEN);
            ib.setHint("P1");
            ib.setGravity(Gravity.CENTER);
            ib.setTextSize(30);
      //      ib.setBackgroundResource(R.drawable.boxes_rounded_corners);
            ((MainLayout) activity).player1_score(++player1_score);
            player_turn--;
            ((MainLayout) activity).change_player1_face(1);
            ((MainLayout) activity).change_player2_face(0);
            System.out.println("in player 1");
        }
        else {
            ib.setBackgroundColor(Color.YELLOW);
            ib.setHint("P2");
            ib.setTextSize(30);
            ib.setGravity(Gravity.CENTER);
     //       ib.setBackgroundResource(R.drawable.boxes_rounded_corners);
            ((MainLayout) activity).player2_score(++player2_score);
            player_turn--;
            ((MainLayout) activity).change_player1_face(0);
            ((MainLayout) activity).change_player2_face(1);
            System.out.println("in player 2");
        }
    }

    public void who_win(){
        int count_filled_boxes=0;

        for(int i=0;i<coloumns;i++){
            for(int j=0; j<rows ; j++){
                if(boxes[i][j]==1){
                    count_filled_boxes++;
                }
            }
        }
        if(count_filled_boxes==(rows*coloumns)){
            if(player1_score>player2_score){
                Toast.makeText(getActivity(), "player1 won", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getActivity(), "player2 won", Toast.LENGTH_SHORT).show();
            }
        }
        System.out.println("in fiilled bboxes");
        System.out.println("number of filled boxes are "+count_filled_boxes);
    }

    public void double_fill_box(TextView ib){
        if(player_turn%2==0){
            ((MainLayout) activity).player1_score(++player1_score);
            ib.setBackgroundColor(Color.GREEN);
            ib.setHint("P1");
            ib.setGravity(Gravity.CENTER);
            ib.setTextSize(30);
        }
        if(player_turn%2==1){
            ((MainLayout) activity).player1_score(++player2_score);
            ib.setBackgroundColor(Color.YELLOW);
            ib.setHint("P2");
            ib.setTextSize(30);
            ib.setGravity(Gravity.CENTER);
        }
    }
}


