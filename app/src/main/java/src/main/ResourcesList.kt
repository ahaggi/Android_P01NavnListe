package src.main

import android.util.Log
import com.example.haji.p01_listview.R;
//
import java.util.ArrayList
import kotlin.reflect.KClass

// https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e
// https://kotlinlang.org/docs/reference/generics.html#variance

open class SingletonCreator<out T, in Any>(creator: (Any) -> T) {
    private var creator: ((Any) -> T)? = creator
    @Volatile
    private var instance: T? = null

    fun getInstance(args1: Any): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(args1)
                instance = created
                creator = null
                created
            }
        }
    }
}


class ResourcesList private constructor(var t: String) {
    internal var imagesIds = ArrayList<String>()

    fun getImagesList(): ArrayList<String> {
//        var d = t as KClass<R.drawable>
        if (imagesIds.size == 0)
            for (felt in R.drawable::class.java.fields)
                try {
                    if (felt.name.matches("^b_+\\S*$".toRegex()))
                        imagesIds.add(felt.name)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

        for (i in imagesIds.indices)
            Log.i("¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤", "%%%%%%%%%%%qwe%%%%%%%%%%%%%%%  " + imagesIds[i])

        return imagesIds
    }



//    (::ResourcesList)


//    companion object : SingletonCreator<ResourcesList,String>(creator = { t: String -> ResourcesList(t ) })
    companion object : SingletonCreator<ResourcesList,String>(::ResourcesList)

}




