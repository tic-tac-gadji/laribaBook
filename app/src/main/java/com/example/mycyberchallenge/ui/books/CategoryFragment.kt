package com.example.mycyberchallenge.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycyberchallenge.models.Book
import com.example.mycyberchallenge.R
import com.example.mycyberchallenge.ui.home.BooksAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class CategoryFragment : Fragment() {

    private val booksList = arrayListOf<Book>()
    private lateinit var adapter: CategoryAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recViewCategories.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        getBooks(view)
    }

    fun getBooks(view: View) {

        val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Category")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                for (snapshot in p0.children) {
                    val book = snapshot.getValue(Book::class.java)
                    booksList.add(book ?: Book())
                }

                view.recViewCategories.adapter =
                    BooksAdapter(booksList)
            }

        })
    }
}