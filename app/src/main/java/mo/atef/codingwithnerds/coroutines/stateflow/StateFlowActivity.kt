package mo.atef.codingwithnerds.coroutines.stateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import mo.atef.codingwithnerds.coroutines.R

class StateFlowActivity : AppCompatActivity() {
    lateinit var timerViewModel: TimerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_flow)
        timerViewModel=ViewModelProvider(this).get(TimerViewModel::class.java)
        val tv:TextView=findViewById(R.id.tvStates)
        timerViewModel.startTimer()

        timerViewModel.timerLiveData.observe(this, Observer {
            tv.text=it.toString()
            Log.d("Here LiveData Observer", it.toString())
        })

        /*
        it observe data only if activity is launched as LiveData is
        a lifecycle aware component in Android Architecture Components
         */
    }
}