package com.practicum.contactscompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practicum.contactscompose.MainActivity.Companion.contacts

@Composable
fun ContactDetails(contactInfo: Contact) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.35f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.weight(0.6f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (contactInfo.imageRes == null) {
                        Icon(
                            painter = painterResource(id = R.drawable.circle),
                            tint = Color.LightGray,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                        Text(
                            style = MaterialTheme.typography.headlineLarge,
                            text = "${contactInfo.name.take(1)}${contactInfo.familyName.take(1)}"
                        )
                    } else {
                        Image(
                            painter = painterResource(contactInfo.imageRes),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                }
            }
            Column(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(top = 18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val surname = if (contactInfo.surname != null) " ${contactInfo.surname}" else ""
                Text(
                    style = MaterialTheme.typography.headlineSmall,
                    text = "${contactInfo.name}$surname"
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        style = MaterialTheme.typography.headlineMedium,
                        text = contactInfo.familyName
                    )
                    if (contactInfo.isFavorite) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.star_big_on),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.65f),
        ) {
            InfoRow(stringResource(R.string.phone), contactInfo.phone)
            InfoRow(stringResource(R.string.address), contactInfo.address)
            contactInfo.email?.let { InfoRow(stringResource(R.string.email), it) }
        }
    }
}

@Composable
fun InfoRow(key: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            style = MaterialTheme.typography.bodyLarge,
            text = "$key:",
            modifier = Modifier
                .weight(0.5f)
                .padding(end = 12.dp),
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Italic
        )
        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = value,
            modifier = Modifier.weight(0.5f)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun EugenePreview() {
    ContactDetails(contacts.first())
}

@Preview(showSystemUi = true)
@Composable
fun NickolasPreview() {
    ContactDetails(contacts.last())
}