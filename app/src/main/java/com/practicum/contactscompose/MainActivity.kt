package com.practicum.contactscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.practicum.contactscompose.ui.theme.ContactsComposeTheme

class MainActivity : ComponentActivity() {

    companion object {
        val contacts = listOf(
            Contact(
                name = "Евгений",
                surname = "Андреевич",
                familyName = "Лукашин",
                isFavorite = true,
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                email = "ELukashin@practicum.ru"
            ),
            Contact(
                name = "Николас",
                familyName = "Кейдж",
                imageRes = R.drawable.contact_photo,
                phone = "---",
                address = "Сан-Францисковская обл., дер. Мемасово, д. 42"
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsComposeTheme {
                ContactDetails(contacts.first())
            }
        }
    }
}