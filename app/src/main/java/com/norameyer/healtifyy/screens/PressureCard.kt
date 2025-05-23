import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PressureCard(
    pressure: String,
    arm: String,
    time: String,
    onClickDelete: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth().padding(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFBEEAD2))) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = time)
            Text(text = pressure)
            Text(text = arm)

            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "delete",
                modifier = Modifier.clickable { onClickDelete() }
            )
        }

    }
}