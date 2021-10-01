package com.android.app.machinetestdiagonal.ui.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.machinetestdiagonal.model.Content
import com.android.app.machinetestdiagonal.model.FilmDataModel
import com.android.app.machinetestdiagonal.utils.ApiProvider
import com.android.app.machinetestdiagonal.utils.Constants
import com.google.gson.Gson
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var contentLivedata = MutableLiveData<ArrayList<Content>>()
    var searchedFilm = MutableLiveData<ArrayList<Content>>()
    var pageNumberLiveData = MutableLiveData<String>()
    var filmList = ArrayList<Content>()
    fun initViewModel(context: Context) {
        loadMore(1, context)
    }

     fun filter(text: String) {
        //new array list that will hold the filtered data
        val searchedFilmList: ArrayList<Content> = ArrayList()

        //looping through existing elements
        for (content in filmList) {
            //if the existing elements contains the search input
            if (content.name.lowercase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                searchedFilmList.add(content)
            }
        }
        searchedFilm.postValue(searchedFilmList)
    }

    fun loadMore(pageNumber: Int, context: Context) {
        var page: String = Constants.page1

        when (pageNumber) {
            1 -> {
                page = Constants.page1
            }
            2 -> {
                page = Constants.page2
            }
            3 -> {
                page = Constants.page3
            }
        }

        viewModelScope.launch {
            val contentData = Gson().fromJson(
                ApiProvider.getJsonFromAssets(context, page),
                FilmDataModel::class.java
            )
            filmList.addAll(contentData.page.content_items.content)
            contentLivedata.postValue(filmList)
            pageNumberLiveData.postValue(contentData.page.page_num)
        }
    }

    private val TAG = "HomeViewModel"


}