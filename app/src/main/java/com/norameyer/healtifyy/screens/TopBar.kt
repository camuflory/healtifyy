import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(txt: String) {
    TopAppBar(
        title = { Text(text = txt, fontSize = 22.sp) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF7DB797))
    )
}