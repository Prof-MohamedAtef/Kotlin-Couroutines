package mo.atef.codingwithnerds.coroutines.stateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mo.atef.codingwithnerds.coroutines.R

class StateFlowActivity : AppCompatActivity() {
    lateinit var timerViewModel: TimerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_flow)
        timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        val tv: TextView = findViewById(R.id.tvStates)
//        timerViewModel.startTimerLiveData()

        timerViewModel.startTimerStateFlow()
        //LiveData example
        timerViewModel.timerLiveData.observe(this, Observer {
//            tv.text=it.toString()
            Log.d("Here LiveData Observer", it.toString())
        })

        //StateFlow example

        GlobalScope.launch {
            timerViewModel.timerStateFlow.collect {
                tv.text = it.toString()
                Log.d("Here StateFlow Observer", it.toString())
            }
        }


        /*
        it observe data only if activity is launched as LiveData is
        a lifecycle aware component in Android Architecture Components
         */
    }
}