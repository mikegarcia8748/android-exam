package com.example.androidtechnicalexamination.ui.activity.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtechnicalexamination.R
import com.example.androidtechnicalexamination.constants.Constants.INTENT_USER_UID
import com.example.androidtechnicalexamination.databinding.ActivityMainBinding
import com.example.androidtechnicalexamination.ui.activity.persondetail.PersonDetailActivity
import com.example.androidtechnicalexamination.ui.component.UsersListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.main?.setOnRefreshListener {
            viewModel?.refreshUserList()
        }

        viewModel?.getUserListForPreview()?.observe(this) { userList ->
            if (userList.isEmpty()) {
                return@observe
            }

            val layoutManager = LinearLayoutManager(this)
            layoutManager.orientation = RecyclerView.VERTICAL

            val userAdapter = UsersListAdapter(
                userList = userList,
                onUserClick = {
                    val intent = Intent(this, PersonDetailActivity::class.java)
                    intent.putExtra(INTENT_USER_UID, it)
                    startActivity(intent)
                }
            )

            binding?.userListRecyclerview?.layoutManager = layoutManager
            binding?.userListRecyclerview?.adapter = userAdapter
        }

        // Handles the preview of loading screen when no records on local is available...
        viewModel?.isLoading()?.observe(this) { isLoading ->
            if (isLoading) {
                binding?.loadingLayout?.visibility = View.VISIBLE
                binding?.contentScrollView?.visibility = View.GONE
            } else {
                binding?.loadingLayout?.visibility = View.GONE
                binding?.contentScrollView?.visibility = View.VISIBLE
            }
        }

        viewModel?.isRefreshing()?.observe(this) { isRefreshing ->
            binding?.main?.isRefreshing = isRefreshing
        }

        viewModel?.getErrorMessage()?.observe(this) { errorMessage ->

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}