package in.codesquad.mycalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
                                                // see this, we implemented an on click lister in main
    public EditText etNum1,etNum2;//we need to change here too
    public TextView etRes;//
    public Button btnAdd,btnSub,btnMul,btnDiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //here we need to initialze the Edit Texts and Buttons
        etNum1= (EditText) findViewById(R.id.etNum1);
        etNum2= (EditText) findViewById(R.id.etNum2);
        etRes=  (TextView) findViewById(R.id.etRes);//we changed EditText to TextView
        btnAdd= (Button) findViewById(R.id.btnAdd);
        btnSub= (Button) findViewById(R.id.btnSub);
        btnMul= (Button) findViewById(R.id.btnMul);
        btnDiv= (Button) findViewById(R.id.btnDiv);
        // so initialized required text fields and buttons
        // Now going to add OnClick functions to buttons
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        //we need to add code here, which should be executed on button click
        // so first of we may save the two numbers.okay...

        int num1=Integer.parseInt(etNum1.getText().toString());//yesss...we got it
        int num2=Integer.parseInt(etNum2.getText().toString());
        float z=0;//we use floating point type since , division return a floating point number like 2.5

        //now we need to check whether the button clicked is + or - or * or /
        if(v.getId()==R.id.btnAdd) z=num1+num2;
        if(v.getId()==R.id.btnSub) z=num1-num2;
        if(v.getId()==R.id.btnMul) z=num1*num2;
        if(v.getId()==R.id.btnDiv) z=(float)num1/num2;

        // now we need to se the results to the textfiels etRes
        etRes.setText(Float.toString(z)); //now ok....
        // everything s fine....Let's Go
    }
}
