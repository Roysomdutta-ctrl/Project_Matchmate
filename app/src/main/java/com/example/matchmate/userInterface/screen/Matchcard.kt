package com.example.matchmate.userInterface.screen

import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.example.matchmate.data.Local.UserEntity
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun MatchCard(user: UserEntity, onAccept: () -> Unit, onDecline: () -> Unit) {
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                GlideImage(
                    imageModel = { user.imageUrl },
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    failure = {
                        Text("Image failed to load") // optional
                    },
                    loading = {
                        CircularProgressIndicator(modifier = Modifier.size(24.dp)) // optional
                    }
                )

/*                val imageSize = 80.dp
                val imageSizePx = with(LocalDensity.current) { imageSize.toPx().toInt() }

                AndroidView(
                    factory = { context ->
                        ImageView(context).apply {
                            layoutParams = ViewGroup.LayoutParams(imageSizePx, imageSizePx)
                            scaleType = ImageView.ScaleType.CENTER_CROP
                        }
                    },
                    update = { imageView ->
                        Glide.with(imageView.context)
                            .load(user.imageUrl)
                            .circleCrop() // optional for circular images
                            .into(imageView)
                    },
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )*/

                Spacer(Modifier.width(16.dp))
                Column {
                    Text(user.fullName, style = MaterialTheme.typography.titleMedium)
                    Text("${user.age} • ${user.location}")
                }
            }

            Spacer(Modifier.height(8.dp))

            if (user.status == "Pending") {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = onAccept) { Text("Accept") }
                    Button(onClick = onDecline, colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)) {
                        Text("Decline")
                    }
                }
            } else {
                val statusColor = if (user.status == "Accepted") Color.Green else Color.Red
                Text("Member ${user.status}", color = statusColor, fontWeight = FontWeight.Bold)
            }
        }
    }
}
