package mo.atef.codingwithnerds.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class CoroutinesJobsActivity : AppCompatActivity() {
    val parentJob:Job=Job()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_jobs)

        val coroutineScope:CoroutineScope= CoroutineScope(Dispatchers.IO+parentJob)

        coroutineScope.launch {
            val child1= launch { getUserDataFromNetwork() }
            val child2= launch { getUserDataFromDatabase() }
            /*
            any other coroutine can be used here
            with the same defined dispatcher and the parent job
             */

            /*
           using coroutine scope with dispatcher IO and Job
            */

            /*
            create global CoroutineScope and combine other background and long-running functions inside it
            with 1 IO Dispatcher for example
             */
        }


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

            /*
            joinAll() is used to communicate jobs together
             */
//            joinAll(child1, child2)

            /*
            cancel and join
            wait the job to be finished then cancel it
             */
//            child1.cancelAndJoin()




            launch { delay(2000) }
        }





    }

    override fun onStop() {
        super.onStop()
        parentJob.cancel()
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