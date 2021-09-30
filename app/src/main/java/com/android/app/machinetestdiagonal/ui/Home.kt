package com.android.app.machinetestdiagonal.ui

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.app.machinetestdiagonal.databinding.ActivityMainBinding
import com.android.app.machinetestdiagonal.model.Content


class Home : AppCompatActivity() {
    private val TAG = "MainActivity"
    var pageNumber :Int =1
    var _binding: ActivityMainBinding? = null
    var _filmContents: List<Content> = ArrayList()
    var adapter: FilmListAdapter? = null
    var viewModel: HomeViewModel? = null
    private val SELECTED_ITEM_POSITION = "ItemPosition"
    private var mPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)
        setUp()

    }

    // extension property to get screen orientation
    val Context.orientation: String
        get() {
            return when (resources.configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> "Portrait"
                Configuration.ORIENTATION_LANDSCAPE -> "Landscape"
                Configuration.ORIENTATION_UNDEFINED -> "Undefined"
                else -> "Error"
            }
        }


    private fun setUp() {

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel?.initViewModel(this)
        viewModel?.contentLivedata?.observe(this, Observer {
            Log.d(TAG, "onCreate: ${it.size}")
            _filmContents = it
            adapter?.updateContent(_filmContents)
        })
        viewModel?.pageNumberLiveData?.observe(this, Observer {
            pageNumber = it.toInt()

        })

        setUpRecyclerView()

        _binding?.ivBack?.setOnClickListener {

        }
        _binding?.ivSearch?.setOnClickListener {

        }
    }

    private fun setUpRecyclerView() {
        if (adapter == null) {
            adapter = FilmListAdapter(_filmContents)
            if (orientation == "Portrait") {
                _binding?.filmContentList?.layoutManager = GridLayoutManager(this, 3)
            } else {
                _binding?.filmContentList?.layoutManager = GridLayoutManager(this, 7)
            }
            _binding?.filmContentList?.adapter = adapter
        }

        _binding?.filmContentList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    Log.d(TAG, "onScrollStateChanged: $pageNumber")
                    if (pageNumber!=3){
                        pageNumber++
                        viewModel?.loadMore(pageNumber,this@Home)
                    }

                }
            }
        })


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // Read the state of item position
        mPosition = savedInstanceState.getInt(SELECTED_ITEM_POSITION)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save the state of item position
        outState.putInt(SELECTED_ITEM_POSITION, mPosition)
    }

}