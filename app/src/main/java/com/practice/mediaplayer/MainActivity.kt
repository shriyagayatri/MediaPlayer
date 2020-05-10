package com.practice.mediaplayer

import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import  kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.song_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listSongs=ArrayList<SongInfo>()
    var adapter:MySongAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoadURLOnline()
        adapter=MySongAdapter(listSongs)
        lvListSongs.adapter=adapter




    }

    fun LoadURLOnline(){
        listSongs.add(SongInfo("001","abc","https://server6.mp3quran.net/thubti/001.mp3"))
        listSongs.add(SongInfo("002","def","https://server6.mp3quran.net/thubti/002.mp3"))
        listSongs.add(SongInfo("003","ghi","https://server6.mp3quran.net/thubti/003.mp3"))
        listSongs.add(SongInfo("004","jkl","https://server6.mp3quran.net/thubti/004.mp3"))
        listSongs.add(SongInfo("005","mno","https://server6.mp3quran.net/thubti/005.mp3"))
    }

    inner  class MySongAdapter:BaseAdapter{
        var  myListSong=ArrayList<SongInfo>()
        constructor(myListSong:ArrayList<SongInfo>):super(){
            this.myListSong=myListSong
        }
        override fun getView(postion: Int, p1: View?, p2: ViewGroup?): View {
            val myView= layoutInflater.inflate(R.layout.song_ticket,null)
            val Song = this.myListSong[postion]
            myView.tvSongName.text = Song.Title
            myView.tvAuthor.text = Song.AuthorName
            myView.buPlay.setOnClickListener(View.OnClickListener {

            })


            return  myView

        }

        override fun getItem(item: Int): Any {
            return this.myListSong[item]
        }

        override fun getItemId(p0: Int): Long {
            return  p0.toLong()
        }

        override fun getCount(): Int {
            return this.myListSong.size
        }


    }



}