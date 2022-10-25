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

        tvPrint = findViewById<TextView>(R.id.tvPrint)

        GlobalScope.launch {
            printTextAfterDelay("atef1")
            printTextAfterDelay("atef2")
        }
    }

    suspend fun printTextAfterDelay(myText: String) = GlobalScope.launch {
        withContext(Dispatchers.IO){
            delay(2000)
            Log.d("MainActivity", myText)
        }
    }
}