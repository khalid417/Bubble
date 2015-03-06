package com.circleattack;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by joshu_000 on 2/23/2015.
 */
public class NodeLayout {

    public enum LayoutType {SQUARE,DIAMOND};

    private LayoutType layoutType;

    private int screenHeight;
    private int screenWidth;


    public LayoutType getLayoutType() {
        return layoutType;
    }

    private int numberOfNodes;


    public NodeLayout( int numberOfNodes, int height, int width){

        screenHeight = height;
        screenWidth = width;

        if(numberOfNodes==4)
            layoutType = LayoutType.SQUARE;

        this.numberOfNodes = numberOfNodes;




    }

    public void GenerateLayout(RelativeLayout layout, Context context){

       switch(layoutType){

           case SQUARE:{

               GenerateSquareLayout(layout, context);
               break;
           }
       }





    }

    /**
     *
     * @param layout
     * @param context
     */
    private void GenerateSquareLayout(RelativeLayout layout, Context context){

        //First get the function
        //Create the layout params
/*        RelativeLayout.LayoutParams buttonParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);



        int sideLength = screenHeight/5;



















        Log.w("screenHeight: ", Integer.toString(screenHeight));
        Log.w("screenWidth: ", Integer.toString(screenWidth));
        Log.w("buttonTopMargin: ", Integer.toString(screenHeight/5));
        Log.w("buttonLeftMargin: ", Integer.toString(screenWidth/5));

        int y = screenHeight/5;
        int x = screenWidth/5;

        buttonParam.topMargin = screenHeight/5;
        buttonParam.leftMargin = screenWidth/5;
        buttonParam.rightMargin = 0;




     ;
        *//*layout.addView(buttonOne);*//*


        int buttonWidth = buttonOne.getWidth();

        double offset = (3.0/5)*(double)screenWidth - 2*buttonWidth;


        Log.w("Offset: ", Double.toString(offset));


        Button buttonTwo = new Button(context);
        buttonTwo.setText(Integer.toString(2));

        //Create the layout params
        buttonParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParam.topMargin = y;
        buttonParam.leftMargin = (int)offset + buttonParam.leftMargin;

        buttonTwo.setLayoutParams(buttonParam);
        layout.addView(buttonTwo);

        Button buttonThree = new Button(context);
        buttonThree.setText(Integer.toString(3));

        //Create the layout params
        buttonParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParam.topMargin = y*2;
        buttonParam.leftMargin = x;

        buttonThree.setLayoutParams(buttonParam);
        layout.addView(buttonThree);


        Button buttonFour = new Button(context);
        buttonFour.setText(Integer.toString(4));

        //Create the layout params
        buttonParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParam.topMargin = y*2;
        buttonParam.leftMargin = (int)offset + buttonParam.leftMargin;
        buttonParam.rightMargin = 0;

        buttonFour.setLayoutParams(buttonParam);
        layout.addView(buttonFour);*/











    }


}
