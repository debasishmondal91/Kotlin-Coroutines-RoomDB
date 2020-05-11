package com.example.koltincoroutinesroomdatabase.ui.userdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.koltincoroutinesroomdatabase.R
import com.example.koltincoroutinesroomdatabase.data.api.ApiHelperImpl
import com.example.koltincoroutinesroomdatabase.data.api.RetrofitBuilder
import com.example.koltincoroutinesroomdatabase.data.local.DatabaseBuilder
import com.example.koltincoroutinesroomdatabase.data.local.DatabaseHelperImpl
import com.example.koltincoroutinesroomdatabase.utils.ViewModelFactory
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var userDetailsViewModel: UserDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        setupViewModel()
        setupObserver()
    }

    private fun setupViewModel() {
        userDetailsViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext)!!)
            )
        )[UserDetailsViewModel::class.java]

        val id = intent.getIntExtra("id", 0)
        userDetailsViewModel.getUserDetails(id)
    }

    private fun setupObserver() {
        userDetailsViewModel.getUserDetails().observe(this, Observer {
            Glide.with(this)
                .load(it.data!!.avatar)
                .into(imageViewAvatar)

            textViewUserName.text = it.data.name
            text_created_at.text = it.data.createdAt

        })
    }
}
