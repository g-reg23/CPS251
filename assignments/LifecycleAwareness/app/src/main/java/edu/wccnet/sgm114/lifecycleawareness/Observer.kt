package edu.wccnet.sgm114.lifecycleawareness

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import edu.wccnet.sgm114.lifecycleawareness.ui.main.MainViewModel
import java.sql.Time
import java.time.LocalDateTime
import java.time.LocalTime

class Observer: LifecycleObserver {
    val mvm: MainViewModel = MainViewModel()
    private val LOG_TAG = "DemoObserver"
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        MainViewModel.Singleton.setText("OnResume was fired at " + LocalTime.now())
        MainViewModel.Singleton.setText("********")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        MainViewModel.Singleton.setText("OnCreate was fired at " + LocalTime.now())
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        MainViewModel.Singleton.setText("OnDestroy was fired at " + LocalTime.now())
        MainViewModel.Singleton.setText("********")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        MainViewModel.Singleton.setText("OnPause was fired at " + LocalTime.now())
        MainViewModel.Singleton.setText("********")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        MainViewModel.Singleton.setText("OnStart was fired at " + LocalTime.now())
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        MainViewModel.Singleton.setText("OnStop was fired at " + LocalTime.now())
    }
}