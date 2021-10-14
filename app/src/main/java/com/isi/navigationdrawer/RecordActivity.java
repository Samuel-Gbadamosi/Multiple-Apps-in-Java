package com.isi.navigationdrawer;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class RecordActivity extends AppCompatActivity {

    //DECLARE VARIABLES
    private TextView startTV , stopTV , playTV , stopplayTV , statusTV;

    //CREATING A VARIABLE FOR MEDI RECORDER OBJECT CLASS
    private MediaRecorder mRecorder;

    //creating a variable for mediaplayerclass
    private MediaPlayer mPlayer;

    //creating string variables for storing a file name
    private static String mFilename = null;

    //constant for storing audio permissions;
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        setTitle("record page");

        //initialize all variables with their layouts items
        statusTV = findViewById(R.id.idTVstatus);
        startTV = findViewById(R.id.btnRecord);
        stopTV =findViewById(R.id.btnStop);
        playTV = findViewById(R.id.btnPlay);
        stopplayTV = findViewById(R.id.btnStopPlay);
        stopTV.setBackgroundColor(getResources().getColor(R.color.black));
        playTV.setBackgroundColor(getResources().getColor(R.color.black));
        stopplayTV.setBackgroundColor(getResources().getColor(R.color.black));


        startTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //starts recording will start the recording of audio
                startRecording();
            }
        });


        stopTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseRecording();
            }
        });

        playTV.setOnClickListener(new View.OnClickListener() {
            @Override
            //plays the recorder
            public void onClick(View view) {
                playAudio();
            }
        });

        stopplayTV.setOnClickListener(new View.OnClickListener() {
            @Override
            //stops the recorder
            public void onClick(View view) {
                pausePlaying();
            }
        });


    }
    private void startRecording() {
        if(CheckPermissions()){
            //setbackgroundcolor method will chane the background color of textview
            stopTV.setBackgroundColor(getResources().getColor(R.color.purple_200));
            startTV.setBackgroundColor(getResources().getColor(R.color.purple_500));
            playTV.setBackgroundColor(getResources().getColor(R.color.purple_200));
            stopplayTV.setBackgroundColor(getResources().getColor(R.color.purple_200));

            //we are here initializing our filename variable with the path of the recorded audio file
            mFilename = Environment.getExternalStorageDirectory().getAbsolutePath();
            mFilename += "/AudioRecording.3gp";

            //below method is used to set the audio source which we are using
            mRecorder = new MediaRecorder();

            //below method is used to set the ausio source which we are using in mic
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

            //BELOW METHOD IS USED TO SET THE AUDIO SOURCE
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

            mRecorder.setOutputFile(mFilename);
            try {
                mRecorder.prepare();
            } catch (IOException e){
                Log.e("TAG" , "prepare() failed");
            }

            mRecorder.start();
            statusTV.setText("Recording started");
        } else{
           RequestPermission();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode , String[] permissions , int[] grantResults){
        //this method is called hen user will grant the permissions for audio recording
        switch(requestCode){
            case REQUEST_AUDIO_PERMISSION_CODE:
                if(grantResults.length > 0){
                    boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean permissionToStore = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if(permissionToRecord && permissionToStore){
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext() , "Permission Denied" , Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    private boolean CheckPermissions(){
          //this method is used to check permission
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext() , RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }


    private void RequestPermission() {
        ActivityCompat.requestPermissions(RecordActivity.this , new String[]{RECORD_AUDIO , WRITE_EXTERNAL_STORAGE} , REQUEST_AUDIO_PERMISSION_CODE);
    }

    private void playAudio() {
        stopTV.setBackgroundColor(getResources().getColor(R.color.purple_500));
        startTV.setBackgroundColor(getResources().getColor(R.color.purple_200));
        playTV.setBackgroundColor(getResources().getColor(R.color.purple_200));
        stopplayTV.setBackgroundColor(getResources().getColor(R.color.purple_200));

        //FOR PLAYING OUR RECORDED AUDIO WE ARE USING MEDIA PLAYER CLASS
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFilename);

            mPlayer.prepare();

            mPlayer.start();
            statusTV.setText("Recording Started playing");
        }catch (IOException e){
            Log.e("TAG" , "prepare() failed");
        }
    }


    private void pauseRecording() {
        stopTV.setBackgroundColor(getResources().getColor(R.color.black));
        startTV.setBackgroundColor(getResources().getColor(R.color.purple_700));
        playTV.setBackgroundColor(getResources().getColor(R.color.purple_700));

        //below method will stop the audio recording
        mRecorder.stop();

        //below method will release the media recorder class
        mRecorder.release();
        mRecorder = null;
        statusTV.setText("Recording Stopped");
    }




    private void pausePlaying() {
        //this method will release the media player
        // class and pause the playinng our record audio
        mPlayer.release();
        mPlayer = null;
        stopTV.setBackgroundColor(getResources().getColor(R.color.black));
        startTV.setBackgroundColor(getResources().getColor(R.color.purple_200));
        playTV.setBackgroundColor(getResources().getColor(R.color.purple_200));
        stopplayTV.setBackgroundColor(getResources().getColor(R.color.black));
        statusTV.setText("Recording play stopped");
    }



}