package mo.atef.codingwithnerds.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow

class FlowActivityImpl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_impl)

        // Producer
        flow<Int> {
            for (i in 1..100){
                emit(i)
            }
        }.filter { i->i<5 } // added intermediate step
    }
}