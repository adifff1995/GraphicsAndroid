package com.app.graphicsandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Player;
import androidx.media3.datasource.RawResourceDataSource;
import androidx.media3.exoplayer.ExoPlayer;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.app.graphicsandroid.databinding.ActivityExoBinding;

public class ExoActivity extends AppCompatActivity {

    ActivityExoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ExoPlayer player = new ExoPlayer.Builder(this).build();

        MediaItem item = MediaItem.fromUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4");
        MediaItem item1 = MediaItem.fromUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4");
        MediaItem item2 = MediaItem.fromUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4");
        MediaItem item3 = MediaItem.fromUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4");

        MediaItem audio = MediaItem.fromUri(RawResourceDataSource.buildRawResourceUri(R.raw.a));
        MediaItem mediaItem = new MediaItem.Builder().setUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4").
                setMimeType(MimeTypes.APPLICATION_MP4).
                setMediaId("ddd").setClippingConfiguration(
                        new MediaItem.ClippingConfiguration.Builder()
                                .setStartPositionMs(60000).setEndPositionMs(90000).build()

                ).build();
        player.addMediaItem(audio);
        player.addMediaItem(item1);
        player.addMediaItem(item2);
        player.addMediaItem(item3);
        player.prepare();
        player.play();
        player.addListener(new Player.Listener() {
            @Override
            public void onPlaybackStateChanged(int playbackState) {
                switch (playbackState) {
                    case Player.STATE_IDLE:
                        Toast.makeText(ExoActivity.this, "STATE_IDLE", Toast.LENGTH_SHORT).show();
                        break;
                    case Player.STATE_BUFFERING:
                        Toast.makeText(ExoActivity.this, "STATE_BUFFERING", Toast.LENGTH_SHORT).show();
                        break;
                    case Player.STATE_READY:
                        Toast.makeText(ExoActivity.this, "STATE_READY", Toast.LENGTH_SHORT).show();
                        break;
                    case Player.STATE_ENDED:
                        Toast.makeText(ExoActivity.this, "STATE_ENDED", Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onIsPlayingChanged(boolean isPlaying) {
                Toast.makeText(ExoActivity.this, isPlaying + "", Toast.LENGTH_SHORT).show();
            }

        });
        binding.playerView.setPlayer(player);
    }
}