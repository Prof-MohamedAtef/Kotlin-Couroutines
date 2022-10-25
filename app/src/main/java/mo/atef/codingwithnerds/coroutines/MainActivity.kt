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
        GlobalScope.launch{
            Log.d("fun", "current Thread : ${Thread.currentThread().name}")
            printTextAfterDelay("atef")
        }

        Log.d("MainActivity", "Back to Main Thread")
    }

    suspend fun printTextAfterDelay(myText: String) {
        GlobalScope.launch(Dispatchers.IO) {
            Log.d("MainActivity", "IO Thread")
            delay(2000)
            withContext(Dispatchers.Main){
                tvPrint?.setText(myText)
            }
        }
    }
}