package ro.pub.cs.systems.eim.practicaltest01var08;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class PlayActivity extends AppCompatActivity {
    private String theAnswer;
    private EditText myAnswer;
    private TextView theRiddle;
    private Button back, check;

    private CallCheckListener checkListener = new CallCheckListener();
    private class CallCheckListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(myAnswer.getText().equals(theAnswer)) {
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        theRiddle = findViewById(R.id.theRiddle);
        myAnswer = findViewById(R.id.myAnswer);
        check = findViewById(R.id.Check);
        check.setOnClickListener(checkListener);
//        back = findViewById(R.id.Back);

        Intent intent = getIntent();
        theRiddle.setText(intent.getStringExtra("riddle"));
        theAnswer = intent.getStringExtra("answer");
    }

}
