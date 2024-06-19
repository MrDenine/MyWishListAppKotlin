package th.learn.mywishlistapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import th.learn.mywishlistapp.data.Wish
import th.learn.mywishlistapp.data.WishRepository

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
) : ViewModel() {
     var wishTitleState by mutableStateOf("")
     var wishDescriptionState by mutableStateOf("")


    fun onWishTitleChange(
        newString:String
    ){
        wishTitleState = newString
    }

    fun onWishDescriptionState( newString:String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWish()
        }
    }

    fun getAWishById(id:Long):Flow<Wish>{
        return wishRepository.getAWishById(id)
    }

    fun addWish(wish:Wish){
        viewModelScope.launch (Dispatchers.IO) {
            wishRepository.addAWish(wish = wish)
        }
    }

    fun updateWish(wish:Wish){
        viewModelScope.launch (Dispatchers.IO) {
            wishRepository.updateAWish(wish = wish)
        }
    }

    fun deleteWish(wish:Wish){
        viewModelScope.launch (Dispatchers.IO) {
            wishRepository.deleteAWish(wish = wish)
        }
    }




}