package com.androidadvance.ultimateandroidtemplaterx.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.androidadvance.ultimateandroidtemplaterx.BaseApplication;
import com.androidadvance.ultimateandroidtemplaterx.di.component.ActivityComponent;
import com.androidadvance.ultimateandroidtemplaterx.di.component.DaggerActivityComponent;

public abstract class BaseActivity extends AppCompatActivity {

  private ActivityComponent mComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mComponent = DaggerActivityComponent.builder().applicationComponent(getApp().getApplicationComponent()).build();
  }

  protected ActivityComponent getComponent() {
    return mComponent;
  }

  protected BaseApplication getApp() {
    return (BaseApplication) getApplicationContext();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override public void onBackPressed() {
    if (getFragmentManager().getBackStackEntryCount() > 0) {
      getFragmentManager().popBackStack();
    } else {
      super.onBackPressed();
    }
  }
}
