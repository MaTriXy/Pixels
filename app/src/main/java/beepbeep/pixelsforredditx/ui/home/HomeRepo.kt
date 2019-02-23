package beepbeep.pixelsforredditx.ui.home

import android.content.Context
import beepbeep.pixelsforredditx.preference.RedditPreference
import com.worker8.redditapi.RedditApi
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomeRepo @Inject constructor(val context: Context) {
    var redditApi: RedditApi

    init {
        redditApi = RedditApi(RedditPreference.getSelectedSubreddit(context))
    }

    fun getMorePosts() = redditApi.getMorePosts()
    fun getMainThread(): Scheduler = AndroidSchedulers.mainThread()
    fun getBackgroundThread(): Scheduler = Schedulers.io()

    fun selectSubreddit(subreddit: String) {
        redditApi = RedditApi(subreddit)
    }

    fun saveSubredditSharedPreference(subreddit: String) =
        RedditPreference.saveSelectedSubreddit(context, subreddit)

    fun getSubredditSharedPreference() =
        RedditPreference.getSelectedSubreddit(context)
}
