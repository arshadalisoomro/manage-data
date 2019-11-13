package pk.inlab.app.managedata.util

import android.content.Context

class FileHelper {
    companion object{
        fun getTextFromResources(context: Context, resourceId: Int): String {
            return context.resources.openRawResource(resourceId).use { res ->
                res.bufferedReader().use { bufRead ->
                    bufRead.readText()
                }
            }
        }
    }
}