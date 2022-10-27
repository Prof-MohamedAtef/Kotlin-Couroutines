package mo.atef.codingwithnerds.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class FlowActivityImpl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_impl)

        /*
        first example
         */
//        runBlocking { //added runblocking to run collect in a coroutine
//        // Producer
//        flow<Int> {
//            for (i in 1..20){
//                emit(i)
//                delay(1000)
//                Log.d("Here Producer", i.toString())
//            }
//        }.filter { i->i<10 } // added intermediate step
//
//            .buffer().collect{   // added buffer to accelerate receiving data from producer
//                delay(2000)
//                Log.d("Here Collector", it.toString())
//            } // added collector to receive data from producer directly - slow way
//
//        }

        // second example
        /*
        added 2 flows and zipped them together.
        Joining these flows to produce an output
         */
        runBlocking {
            val flow1 = flow<Int> {
                for (i in 1..3) {
                    emit(i)
                    delay(1000)
                }
            }

            val flow2 = flow<String> {

                val list= listOf<String>("A", "B", "C")
                for (i in list) {
                    emit(i)
                    delay(3000)
                }
            }


            flow1.zip(flow2){ a,b->"$a:$b"

            }.collect{
                Log.d("Here", it)
            }
        }
    }
}