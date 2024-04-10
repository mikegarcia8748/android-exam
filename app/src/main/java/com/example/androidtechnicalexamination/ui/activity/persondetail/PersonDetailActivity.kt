package com.example.androidtechnicalexamination.ui.activity.persondetail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.androidtechnicalexamination.R
import com.example.androidtechnicalexamination.constants.Constants.INTENT_USER_UID
import com.example.androidtechnicalexamination.databinding.ActivityPersonDetailBinding
import com.example.androidtechnicalexamination.extension.getAge
import com.example.androidtechnicalexamination.extension.toUiPreview
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailActivity : AppCompatActivity() {

    private var binding: ActivityPersonDetailBinding? = null
    private var viewModel: PersonDetailViewModel? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPersonDetailBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[PersonDetailViewModel::class.java]
        setContentView(binding?.root)

        val userUid = intent.getStringExtra(INTENT_USER_UID)

        viewModel?.getUserDetail(userUid.orEmpty())?.observe(this) { user ->
            if (user == null) { return@observe }

            Picasso.get().load(user.largeImage).into(binding?.imgUserPhoto)

            val firstName = user.firstName
            val lastName = user.lastName
            binding?.labelUserFullName?.text = "$firstName $lastName"

            val age = user.birthday?.getAge()
            binding?.labelUserAge?.text = "$age Years Old"

            binding?.labelBirthDate?.text = user.birthday?.toUiPreview()
            binding?.labelEmailAddress?.text = user.emailAddress
            binding?.labelMobileNumber?.text = user.mobileNo

            val street = user.street.orEmpty()
            val number = user.number.orEmpty()
            val city = user.city.orEmpty()
            val state = user.state.orEmpty()
            val country = user.country.orEmpty()
            binding?.labelUserFullAddress?.text = "$number $street, $city, $state, $country"

            binding?.labelContactPerson?.text = user.contactPerson
            binding?.labelContactPersonMobileNo?.text = user.contactPersonMobileNo
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}