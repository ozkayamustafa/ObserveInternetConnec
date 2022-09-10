package com.mustafa.observeinternetconnec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var connetivityObserve:ConnectivityObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connetivityObserve = NetworkConnectivityObserve(applicationContext)
          connetivityObserve.observe().onEach {
              changeNetwork.text = it.toString()
          }.launchIn(scope = CoroutineScope(Dispatchers.Main))
    }
}