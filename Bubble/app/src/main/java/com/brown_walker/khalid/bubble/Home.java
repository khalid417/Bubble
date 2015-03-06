package com.circleattack;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Home extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Find the relative layout
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);








        //Get the dimensions of the screen
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        //Get the height of the title bar:
        int heightTitle = getResources().getIdentifier("status_bar_height",
                "dimen",
                "android");
        if (heightTitle > 0) {
            heightTitle = getResources().getDimensionPixelSize(heightTitle);
        }

        Log.w("titleBarHeight",Integer.toString(heightTitle));

        //Subtract the height of the title from the screenHeight
        height = height - heightTitle;

       /* CreateNodes(4, layout, height, width);*/


        //First get the function
        //Create the layout params
        RelativeLayout.LayoutParams buttonParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);





        int sideLength = height/3;


        Button buttonOne = (Button)findViewById(R.id.button);


        RelativeLayout.LayoutParams centerParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        /*RelativeLayout.LayoutParams centerParam = (RelativeLayout.LayoutParams)layout.getLayoutParams();*/

        TextView center = new TextView(this);

        center.setId(View.generateViewId());

        center.setText("Center");




        centerParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
        centerParam.addRule(RelativeLayout.CENTER_VERTICAL);
        center.setLayoutParams(centerParam);


        layout.addView(center);


        int heightOffset = sideLength - buttonOne.getHeight();
        int widthOffset = sideLength - buttonOne.getWidth();

        buttonParam.rightMargin=widthOffset/2;
        buttonParam.bottomMargin=heightOffset/2;
/*        buttonParam.addRule(RelativeLayout.ALIGN_BASELINE,center.getId());
        buttonParam.addRule(RelativeLayout.ABOVE,center.getId());
        buttonParam.addRule(RelativeLayout.LEFT_OF,center.getId());*/




        buttonOne.setLayoutParams(buttonParam);


        buttonParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        Button buttonTwo = (Button)findViewById(R.id.button2);


        buttonParam.leftMargin=widthOffset/2;
        buttonParam.bottomMargin=heightOffset/2;

/*        buttonParam.addRule(RelativeLayout.ALIGN_BASELINE,center.getId());
        buttonParam.addRule(RelativeLayout.ABOVE,center.getId());
        buttonParam.addRule(RelativeLayout.RIGHT_OF,center.getId());*/

        buttonTwo.setLayoutParams(buttonParam);


        buttonParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        Button buttonThree = (Button)findViewById(R.id.button3);


        buttonParam.rightMargin=widthOffset/2;
        buttonParam.topMargin=heightOffset/2;

/*        buttonParam.addRule(RelativeLayout.ALIGN_BASELINE,center.getId());
        buttonParam.addRule(RelativeLayout.BELOW,center.getId());
        buttonParam.addRule(RelativeLayout.LEFT_OF,center.getId());*/


        buttonThree.setLayoutParams(buttonParam);


        buttonParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        Button buttonFour = (Button)findViewById(R.id.button4);


        buttonParam.leftMargin=widthOffset/2;
        buttonParam.topMargin=heightOffset/2;

/*
        buttonParam.addRule(RelativeLayout.ALIGN_BASELINE,center.getId());

        buttonParam.addRule(RelativeLayout.RIGHT_OF,center.getId());
        buttonParam.addRule(RelativeLayout.BELOW,center.getId());*/

        buttonFour.setLayoutParams(buttonParam);




    }






    public void CreateNodes(int nodeNumber, RelativeLayout layout, int height, int width){

        //First get the function


        NodeLayout nodeLayout = new NodeLayout(nodeNumber, height, width);

        nodeLayout.GenerateLayout(layout, this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
