package beepbeep.pixelsforredditx

import android.app.Application
import android.content.Context

class PixelApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        private var appContext: Context? = null
    }
}
