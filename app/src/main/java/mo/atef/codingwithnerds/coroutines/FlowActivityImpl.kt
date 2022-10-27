package mo.atef.codingwithnerds.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class FlowActivityImpl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_impl)

        runBlocking { //added runblocking to run collect in a coroutine
        // Producer
        flow<Int> {
            for (i in 1..20){
                emit(i)
                delay(1000)
                Log.d("Here Producer", i.toString())
            }
        }.filter { i->i<10 } // added intermediate step

            .buffer().collect{   // added buffer to accelerate receiving data from producer
                delay(2000)
                Log.d("Here Collector", it.toString())
            } // added collector to receive data from producer directly - slow way

        }
    }
}