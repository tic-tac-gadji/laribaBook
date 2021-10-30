package com.example.mycyberchallenge.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.mycyberchallenge.R
import com.example.mycyberchallenge.models.Banner
import com.example.mycyberchallenge.models.Book
import com.example.mycyberchallenge.models.Puzzle
import com.example.mycyberchallenge.ui.notifications.PuzzleAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class HomeFragment : Fragment() {

    private lateinit var snapHelper: SnapHelper
    private lateinit var imageBanners: BannersAdapter
    private var bannersList = arrayListOf<Banner>()
    private var booksList = arrayListOf<Book>()
    private var puzzleList = arrayListOf<Puzzle>()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBooks()
        getBanners()
        getPuzzle()
        initViews(view)
    }



    private fun initViews(view: View) {

        view.recViewBanners.run {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(this)
            isNestedScrollingEnabled = false
            //view.bannersIndicator.attachToRecyclerView(this)
        }

        view.recViewCategories.run {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(this)
            isNestedScrollingEnabled = false

        }

        view.recViewTasks.run {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(this)
            isNestedScrollingEnabled = false

        }
    }

    private fun getBanners() {

        val reference = FirebaseDatabase.getInstance().getReference("banners")
        reference.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context, p0.message, Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (snapshot in p0.children) {
                    val banner = snapshot.getValue(Banner::class.java)
                    bannersList.add(banner ?: Banner())
                }

                view?.recViewBanners?.adapter = BannersAdapter(bannersList)
            }
        })
    }

    private fun getBooks() {
        val reference = FirebaseDatabase.getInstance().getReference("booksBanners")
        reference.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context, p0.message, Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (snapshot in p0.children) {
                    val books = snapshot.getValue(Book::class.java)
                    booksList.add(books ?: Book())
                }

                view?.recViewCategories?.adapter =
                    BooksAdapter(booksList)
            }
        })

    }

    private fun getPuzzle() {
        val reference = FirebaseDatabase.getInstance().getReference("pazzleBanners")
        reference.addValueEventListener(object : ValueEventListener {


            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context, p0.message, Toast.LENGTH_LONG).show()
            }


            override fun onDataChange(p0: DataSnapshot) {
                for (snapshot in p0.children) {
                    val puzzle = snapshot.getValue(Puzzle::class.java)
                    puzzleList.add(puzzle ?: Puzzle())
                }

                view?.recViewTasks?.adapter = PuzzleAdapter(puzzleList)
            }
        })
    }




}
