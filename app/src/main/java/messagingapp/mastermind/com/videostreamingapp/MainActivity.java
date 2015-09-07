package messagingapp.mastermind.com.videostreamingapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity{

    VideoView videoView;
    //The string that holds the url for the specific video
    String vidUrl = "https://ia800300.us.archive.org/25/items/3stooges/3stooges_NewApants2_512kb.mp4";

    Uri uri = Uri.parse(vidUrl);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Find the VideoView using the id
        videoView = (VideoView)findViewById(R.id.videoView);



        //now set the Uri in the videoView
        videoView.setVideoURI(uri);

        //Create a controller for the video
        MediaController controller = new MediaController(this);

        //setAnchorView uses the parent of the VideoView as an Anchor
        controller.setAnchorView(videoView);


        videoView.setMediaController(controller);

        videoView.start();

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
}
