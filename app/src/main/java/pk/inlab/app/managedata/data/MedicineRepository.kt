package pk.inlab.app.managedata.data

import android.content.Context
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import pk.inlab.app.managedata.R
import pk.inlab.app.managedata.util.FileHelper

class MedicineRepository {

    // Parameterized type variable
    private val listType = Types.newParameterizedType(
        List::class.java, Medicine::class.java
    )

    fun getMedicineData(context: Context): List<Medicine>{
        val text = FileHelper.getTextFromResources(context, R.raw.medicine_data)
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Medicine>>
                = moshi.adapter(listType)
        return adapter.fromJson(text) ?: emptyList()

    }
}