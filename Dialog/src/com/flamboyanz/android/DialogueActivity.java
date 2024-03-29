package com.flamboyanz.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
public class DialogueActivity extends Activity {
    CharSequence[] items = { "Google", "Apple", "Microsoft" };
    boolean[] itemsChecked = new boolean [items.length];
    private ProgressDialog _progressDialog;
    private int _progress = 0;
    private Handler _progressHandler;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) findViewById(R.id.btn_dialog);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(1);
                _progress = 0;
                _progressDialog.setProgress(0);
                _progressHandler.sendEmptyMessage(0);
            }
        });
        _progressHandler = new Handler(){
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (_progress >= 100) {
                    _progressDialog.dismiss();
                    Toast.makeText(getBaseContext(), "Download Successful", Toast.LENGTH_LONG).show();
                } else {
                    _progress++;
                    _progressDialog.incrementProgressBy(1);
                    _progressHandler.sendEmptyMessageDelayed(0, 100);
                }
            }
        };
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case 0:
            return new AlertDialog.Builder(this)
            //...
            //...
            .create();
        case 1:
            _progressDialog = new ProgressDialog(this);
            _progressDialog.setIcon(R.drawable.icon);
            _progressDialog.setTitle("Downloading files...");
            _progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            _progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Hide", new
                DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,
                    int whichButton)
                {
                    Toast.makeText(getBaseContext(),
                            "Hide clicked!", Toast.LENGTH_SHORT).show();
                }
            });
            _progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new
                DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,
                    int whichButton)
                {
                    Toast.makeText(getBaseContext(),
                            "Cancel clicked!", Toast.LENGTH_SHORT).show();
                }
            });
            return _progressDialog;
        }
        return null;
    }
    
}
