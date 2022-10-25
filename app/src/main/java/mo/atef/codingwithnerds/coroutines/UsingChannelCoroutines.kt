package mo.atef.codingwithnerds.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UsingChannelCoroutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_using_channel_coroutines)

        val kotlinChannel=Channel<String>()

        val charList= arrayOf("A", "B", "C", "D")
        runBlocking {
            launch {
                for (char in charList){
                    kotlinChannel.send(char)
                    delay(1000)
                }
            }
            launch {
                for (char in kotlinChannel){
                    Log.d("Channel", char)
                }
            }
        }
    }


}