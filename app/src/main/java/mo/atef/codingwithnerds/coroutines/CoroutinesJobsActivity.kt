package mo.atef.codingwithnerds.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class CoroutinesJobsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_jobs)


        val parentJob = Job()
        val job:Job = GlobalScope.launch(parentJob) {
            /*
            if network call failed, the database call will fail as all of the job will fail.
             */
            val child1= launch { getUserDataFromNetwork() }
            val child2= launch { getUserDataFromDatabase() }

            /*
            delay after both child1 and child2 coroutines finishes
             */
//            child1.join()
//            child2.join()

            joinAll(child1, child2)

            launch { delay(2000) }
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