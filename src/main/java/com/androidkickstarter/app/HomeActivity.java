
package com.androidkickstarter.app;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import static java.lang.String.format;

public class HomeActivity
        extends Activity {

    private TextView versionName;
    private TextView versionCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        versionName = ((TextView) findViewById(R.id.version_name));
        versionCode = (TextView) findViewById(R.id.version_code);

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionName.setText(format("Version name: %s" ,packageInfo.versionName));
            versionCode.setText(format("Version code: %s" ,packageInfo.versionCode));

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater();
        return true;
    }

}
