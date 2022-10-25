package mo.atef.codingwithnerds.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class AsyncAwaitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_await)

        GlobalScope.launch {
            val time= measureTimeMillis {
                val apiData = async { getUserDataFromNetwork() }
                val dbData = async { getUserDataFromDatabase() }

                if (apiData.await() == dbData.await()) {
                    Log.d("AsyncAwaitActivity", "Equals")
                } else {
                    Log.d("AsyncAwaitActivity", "not Equals")
                }
            }

            Log.d("AsyncAwaitActivity", time.toString())
        }
    }


    suspend fun getUserDataFromNetwork():String{
        delay(2000)
        return "Atef"

    }

    suspend fun getUserDataFromDatabase():String{
        delay(4000)
        return "Atef"
    }
}