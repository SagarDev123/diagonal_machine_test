package com.android.app.machinetestdiagonal.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.app.machinetestdiagonal.R
import com.android.app.machinetestdiagonal.databinding.ItemFilmContentBinding
import com.android.app.machinetestdiagonal.model.Content
import com.android.app.machinetestdiagonal.utils.MachineTestApp

class FilmListAdapter(var filmList:List<Content>) : RecyclerView.Adapter<FilmListAdapter.FilmVH>() {
    class FilmVH(val itemFilmContentBinding: ItemFilmContentBinding) :RecyclerView.ViewHolder(itemFilmContentBinding.root){

        private  val TAG = "FilmListAdapter"

                 fun bindContent(content: Content) {
                     itemFilmContentBinding.content=content
                     itemFilmContentBinding.ivPoster.setImageDrawable(MachineTestApp.instance?.resources?.getDrawable(getImageDrawable_(content.poster_image)))
                 }

        private fun getImageDrawable_(posterImage: String): Int {

            Log.d(TAG, "getImageDrawable_: $posterImage")


            when(posterImage){
                "poster1.jpg"->{
                    return R.drawable.poster1
                }
                "poster2.jpg"->{
                    return R.drawable.poster2
                }
                "poster3.jpg"->{
                    return R.drawable.poster3
                }
                "poster4.jpg"->{
                    return R.drawable.poster4
                }
                "poster5.jpg"->{
                    return R.drawable.poster5
                }
                "poster6.jpg"->{
                    return R.drawable.poster6
                }
                "poster7.jpg"->{
                    return R.drawable.poster7
                }
                "poster8.jpg"->{
                    return R.drawable.poster8
                }
                "poster9.jpg"->{
                    return R.drawable.poster9
                }
            }
            return R.drawable.placeholder_for_missing_posters
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmVH {

        val itemFilmContentBinding = ItemFilmContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return FilmVH(itemFilmContentBinding)
    }

    override fun onBindViewHolder(holder: FilmVH, position: Int) {
         holder.bindContent(filmList[position])
    }

    override fun getItemCount(): Int {
        return  filmList.size
    }

    fun updateContent(_filmContents: List<Content>) {
        this.filmList = _filmContents
        notifyDataSetChanged()
    }
}