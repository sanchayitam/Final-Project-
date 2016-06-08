package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
        @see <a href="https://gist.github.com/he9lin/2195897">How to test AsyncTask in Android</a>
 */
/**
 * Created by sanch on 5/15/2016.
 */

@RunWith(AndroidJUnit4.class)
public class TestForNonMTStr extends AndroidTestCase implements OnsetJokeListener {

          private static final String LOG_TAG = "TestForMTString";
          String result = null;
          // create  a signal to let us know when our task is done.
          final CountDownLatch signal = new CountDownLatch(1);

    @Test
           public void test() {

            // Testing that Async task successfully retrieves a non-empty string
            // You can test this from androidTest -> Run 'All Tests'
            Log.v("LOG_TAG", "Running NonEmptyStringTest test");

            try {
                new EndpointsAsyncTask().execute(this);
                signal.await(10, TimeUnit.SECONDS);

                Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
                    assertNotNull(result);
        }

    @Override
    public void onReceived(String joke) {
        this.result = joke;
        signal.countDown();
    }
}
