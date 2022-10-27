package mo.atef.codingwithnerds.coroutines.stateflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TimerViewModel:ViewModel() {
    private val _timerLiveData=MutableLiveData<Int>()
    public val timerLiveData:LiveData<Int?>
        get() = _timerLiveData

    private val _timerStateFlow= MutableStateFlow<Int>(0)
    public val timerStateFlow:StateFlow<Int?>
    get() = _timerStateFlow

    public fun startTimerStateFlow(){
        viewModelScope.launch {
            for (i in 1..10){
                _timerStateFlow.emit(i)
                delay(1000)
            }
        }
    }


    public fun startTimerLiveData(){
        viewModelScope.launch {
            val list= listOf<Int>(1,1,2,2,2,3,4,5,5,6,7,7,8,8,9,10)
            for (i in list){
                _timerLiveData.value=i
                delay(1000)
            }
        }
    }
}