package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

public class PhoneDialerActivity extends AppCompatActivity {

    EditText text;
    GridLayout grid;

    class PhoneDialerButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            String currentText = text.getText().toString();

            switch (v.getId()) {
                case R.id.clear_button:
                    text.setText(currentText.substring(0, currentText.length() - 1));
                    break;

                case R.id.one_button:
                    text.setText(currentText + "1");
                    break;

                case R.id.two_button:
                    text.setText(currentText + "2");
                    break;

                case R.id.three_button:
                    text.setText(currentText + "3");
                    break;

                case R.id.four_button:
                    text.setText(currentText + "4");
                    break;

                case R.id.five_button:
                    text.setText(currentText + "5");
                    break;

                case R.id.six_button:
                    text.setText(currentText + "6");
                    break;

                case R.id.seven_button:
                    text.setText(currentText + "7");
                    break;


                case R.id.eight_button:
                    text.setText(currentText + "8");
                    break;

                case R.id.nine_button:
                    text.setText(currentText + "9");
                    break;

                case R.id.zero_button:
                    text.setText(currentText + "0");
                    break;

                case R.id.star_button:
                    text.setText(currentText + "*");
                    break;

                case R.id.hashtag_button:
                    text.setText(currentText + "#");
                    break;

                case R.id.call_button:
                    if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                                PhoneDialerActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                1);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + text.getText().toString()));
                        startActivity(intent);
                    }
                    break;

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        text = (EditText) findViewById(R.id.show_text);

        grid = (GridLayout) findViewById(R.id.button_grid);
        int count = grid.getChildCount();
        for (int i = 0; i < count; i++) {
            View childAt = grid.getChildAt(i);
            childAt.setOnClickListener(new PhoneDialerButtonListener());
        }
    }
}
