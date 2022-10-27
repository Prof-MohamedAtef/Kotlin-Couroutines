package mo.atef.codingwithnerds.coroutines.stateflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerViewModel:ViewModel() {
    private val _timerLiveData=MutableLiveData<Int>()
    public val timerLiveData:LiveData<Int?>
        get() = _timerLiveData

    public fun startTimer(){
        viewModelScope.launch {
            for (i in 1..10){
                _timerLiveData.value=i
                delay(1000)
            }
        }
    }
}