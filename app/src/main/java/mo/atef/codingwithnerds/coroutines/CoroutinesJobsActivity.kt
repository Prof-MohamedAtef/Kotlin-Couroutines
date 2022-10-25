package mo.atef.codingwithnerds.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesJobsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_jobs)


        val parentJob = Job()
        val job:Job = GlobalScope.launch(parentJob) {
            /*
            if network call failed, the database call will fail as all of the job will fail.
             */
            launch { getUserDataFromNetwork() }
            launch { getUserDataFromDatabase() }
        }

        job.cancel()
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