package com.snow.zxing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.snow.zx.zxing.CaptureActivity;

public class MainActivity extends AppCompatActivity
{
  TextView tv;
  private static final int SCANNING_REQUEST_CODE = 853;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.scan_btn).setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, SCANNING_REQUEST_CODE);
      }
    });

    tv = (TextView) findViewById(R.id.textView);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode)
    {
      case SCANNING_REQUEST_CODE:
        if (resultCode == RESULT_OK)
        {
          if (data != null)
          {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            tv.setText(result);
          }
        }
        break;
      default:
        break;
    }
  }
}
