package com.example.matchmate.userInterface.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.matchmate.viewModel.MainViewModel

@Composable
fun UserListScreen(viewModel: MainViewModel) {
    val users by viewModel.users.observeAsState(emptyList())

    LazyColumn (modifier = Modifier
        .fillMaxSize()){
        items(users) { user ->
            MatchCard(
                user = user,
                onAccept = { viewModel.updateUserStatus(user, "Accepted") },
                onDecline = { viewModel.updateUserStatus(user, "Declined") }
            )
        }
    }
}
