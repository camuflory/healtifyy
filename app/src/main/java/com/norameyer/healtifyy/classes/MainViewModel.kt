import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.norameyer.healtifyy.classes.App
import com.norameyer.healtifyy.data.MainDB
import com.norameyer.healtifyy.data.PillsEntity
import com.norameyer.healtifyy.data.PressureEntity
import com.norameyer.healtifyy.data.SugarEntity
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// класс для связи работы базы данных и визуала
class MainViewModel(private val db: MainDB) : ViewModel() {

    val allPressure = db.pressureDao.getAllPressure()  // все значения давления из бд
    val allPills = db.pillsDao.getAllPills()  // все значения таблеток из бд
    val allSugar = db.sugarDao.getAllSugar()  // все значения сахара из бд

    private var currPressure: PressureEntity? = null  // текущий объект давления для добавления в бд
    private var currPills: PillsEntity? = null  // текущий объект таблеток для добавления в бд
    private var currSugar: SugarEntity? = null  // текущий объект сахара для добавления в бд

    var textPressure = mutableStateOf("")  // текущее значение давления
    var textSugar = mutableStateOf("")  // текущее значение сахара
    var textPills = mutableStateOf("")  // текущее название таблеток
    var textDose = mutableStateOf("")  // текущее значение дозировки таблетки
    var textArm = mutableStateOf("")  // текущее значение руки, на которой мерялось давление

/////////////////////////////////////////////////////////////////////////////////////////////////

    fun insertPressure() = viewModelScope.launch {
        // Добавление давления в бд */
        if (textPressure.value != "" && textArm.value != "") {
            val item = currPressure?.copy(  // создание копии объекта для добавления в бд
                pressure = textPressure.value,
                time = getCurrentTime(),
                arm = textArm.value) ?: PressureEntity(
                pressure = textPressure.value,
                time = getCurrentTime(),
                arm = textArm.value
            )
            db.pressureDao.insertPressure(item)  // добавление в бд
            currPressure = null
            textPressure.value = ""
            textArm.value = ""
        }
    }

    fun insertSugar() = viewModelScope.launch {
        // Добавление сахара в бд */
        if (textSugar.value != "") {
            val item = currSugar?.copy(  // создание копии объекта для добавления в бд
                rate = textSugar.value,
                time = getCurrentTime()) ?: SugarEntity(
                rate = textSugar.value,
                time = getCurrentTime()
            )
            db.sugarDao.insertSugar(item)  // добавление в бд
            currSugar = null
            textSugar.value = ""
        }
    }

    fun insertPills() = viewModelScope.launch {
        // Добавление таблеток в бд */
        if (textPills.value != "" && textDose.value != "") {
            val item = currPills?.copy(  // создание копии объекта для добавления в бд
                time = getCurrentTime(),
                pillsName = textPills.value,
                amount = textDose.value) ?: PillsEntity(
                time = getCurrentTime(),
                pillsName = textPills.value,
                amount = textDose.value
            )
            db.pillsDao.insertPills(item)  // добавление в бд
            currPills = null
            textPills.value = ""
            textDose.value = ""
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////

    fun deletePressure(pressureEntity: PressureEntity) = viewModelScope.launch {
        // Удаленияе давления из бд */
            db.pressureDao.deletePressure(pressureEntity)
    }

    fun deleteSugar(sugarEntity: SugarEntity) = viewModelScope.launch {
        // Удаленияе сахара из бд */
            db.sugarDao.deleteSugar(sugarEntity)
    }

    fun deletePills(pillsEntity: PillsEntity) = viewModelScope.launch {
        // Удаленияе таблеток из бд */
            db.pillsDao.deletePills(pillsEntity)
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////
    companion object {
        // создание объекта типа MainViewModel в функциях визуала
        val factory: ViewModelProvider.Factory = object  : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.
                APPLICATION_KEY]) as App).database
                return MainViewModel(database) as T
            }
        }
    }

    private fun getCurrentTime() : String {
        /** текущее время в виде строки */
        val sdf = SimpleDateFormat("dd.MM HH:mm", Locale.getDefault())
        val date = Date(System.currentTimeMillis())
        return sdf.format(date)
    }

}