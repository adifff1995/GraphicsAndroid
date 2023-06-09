package com.app.graphicsandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Player;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.DefaultDataSourceFactory;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.RawResourceDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;

import android.os.Bundle;
import android.util.Log;

import com.app.graphicsandroid.databinding.ActivityExpPlayerTestBinding;

public class ExpPlayerTestActivity extends AppCompatActivity {
    ActivityExpPlayerTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExpPlayerTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ExoPlayer player = new ExoPlayer.Builder(this).build();
//        MediaItem mediaItem = new MediaItem.Builder().setUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
//                .setMimeType(MimeTypes.APPLICATION_MP4).build();
//        DataSource.Factory dataSourceFactory = new DefaultHttpDataSource.Factory();
//
//        MediaSource mediaSource =
//                new ProgressiveMediaSource.Factory(dataSourceFactory)
//                        .createMediaSource(mediaItem);
//
//        player.setMediaSource(mediaSource);
        MediaItem mediaItem = MediaItem.fromUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4");
        MediaItem audi = MediaItem.fromUri(RawResourceDataSource.buildRawResourceUri(R.raw.a));
        MediaItem audi2 = MediaItem.fromUri("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
//        MediaItem secondItem = MediaItem.fromUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4");
//        MediaItem item = new MediaItem.Builder().setUri("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
//                .setClippingConfiguration(new MediaItem.ClippingConfiguration.Builder()
//                        .setStartPositionMs(3000)
//                        .setEndPositionMs(50000)
//                        .build()
//                ).build();

        player.addMediaItem(audi2);

//        player.seekTo(10000);
//        player.setPlaybackSpeed(2f);

//        player.addMediaItem(secondItem);
        player.prepare();
        binding.playerView.setPlayer(player);
        player.addListener(new Player.Listener() {
            @Override
            public void onPlaybackStateChanged(int playbackState) {
                Log.e("STATE_IDLE: ", playbackState + "");

                switch (playbackState) {
                    case Player.STATE_IDLE:
                        Log.e("STATE_IDLE: ", "STATE_IDLE");
                        break;

                    case Player.STATE_BUFFERING:
                        Log.e("STATE_BUFFERING: ", "STATE_BUFFERING");
                        break;

                    case Player.STATE_ENDED:
                        Log.e("STATE_ENDED: ", "STATE_ENDED");
                        break;
                }
            }

            @Override
            public void onIsPlayingChanged(boolean isPlaying) {
                Log.e("onIsPlayingChanged: ", isPlaying + "");
            }

        });
        player.play();

    }
}