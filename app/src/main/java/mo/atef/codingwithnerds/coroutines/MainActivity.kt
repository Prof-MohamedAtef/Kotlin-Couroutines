package mo.atef.codingwithnerds.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var tvPrint: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPrint=findViewById<TextView>(R.id.tvPrint)

        Log.d("MainActivity", "Main Thread")
        runBlocking{
            Log.d("fun", "MainActivity, Thread is : ${Thread.currentThread().name}")
            printTextAfterDelay("atef")
            tvPrint?.text="atef"

        }

        Log.d("MainActivity", "Back to Main Thread")
    }

    suspend fun printTextAfterDelay(myText: String) {
        Log.d("MainActivity", "IO Thread")
        delay(2000)
    }
}