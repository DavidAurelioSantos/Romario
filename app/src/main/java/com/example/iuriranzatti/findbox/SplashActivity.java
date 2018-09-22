package com.example.iuriranzatti.findbox;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    protected static final int tempo = 10000;
    protected boolean mbActive;
    protected ProgressBar progressBar;
    public TextView msgCarrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        msgCarrega = (TextView) findViewById(R.id.msgCarrega);

        final Thread timerThread = new Thread(){
            @Override
            public void run() {
                mbActive = true;
                try {
                    int waited = 0;
                    while (mbActive && (waited < tempo)) {
                        sleep(90);
                        if(mbActive) {
                            if(waited == 2000) {
                                msgCarrega.setText("Carregando módulos".toString());
                            } else if (waited == 4000) {
                                msgCarrega.setText("Carregando componentes".toString());
                            } else if (waited == 6000) {
                                msgCarrega.setText("Carregando métodos".toString());
                            } else if (waited == 8000) {
                                msgCarrega.setText("Carregando layouts".toString());
                            }
                            waited += 200;
                            updateProgess(waited);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            private void updateProgess(final int timePassed) {
                if(null != progressBar) {
                    final int progress = progressBar.getMax() * timePassed / tempo;
                    progressBar.setProgress(progress);
                }
            }
        };
        timerThread.start();

        // Ocultadndo a Action Bar
//        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(  new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent(getBaseContext(),MainActivity.class));
                finish();
            }
        }, 5000);
    }
}
