package pk.inlab.app.managedata.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import pk.inlab.app.managedata.R
import pk.inlab.app.managedata.data.Medicine
import pk.inlab.app.managedata.data.MedicineRepository
import pk.inlab.app.managedata.util.FileHelper


class MainViewModel(app: Application) : AndroidViewModel(app) {
    private val dataRepo = MedicineRepository()
    val medicineData = MutableLiveData<List<Medicine>>()

    init {
        medicineData.value = dataRepo.getMedicineData(app)
    }

}
