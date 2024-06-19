package th.learn.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDoa: WishDao) {

    fun getWish() : Flow<List<Wish>> = wishDoa.getAllWish()

    fun getAWishById(id:Long) : Flow<Wish>{
        return wishDoa.getAllWishById(id)
    }

    suspend fun addAWish(wish: Wish){
        wishDoa.addAWish(wish)
    }

    suspend fun updateAWish(wish: Wish){
        wishDoa.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDoa.deleteAWish(wish)
    }


}