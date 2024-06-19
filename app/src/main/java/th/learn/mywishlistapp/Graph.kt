package th.learn.mywishlistapp

import android.content.Context
import androidx.room.Room
import th.learn.mywishlistapp.data.WishDatabase
import th.learn.mywishlistapp.data.WishRepository

object Graph {
     lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDoa = database.wishDoa())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(
            context,
            WishDatabase::class.java,
            "wishlist.db"
        ).build()
    }
}