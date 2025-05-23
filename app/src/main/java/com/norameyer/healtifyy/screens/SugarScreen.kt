import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SugarScreen(mvm: MainViewModel = viewModel(factory = MainViewModel.factory)) {

    val allSugar = mvm.allSugar.collectAsState(initial = emptyList())

    Scaffold(topBar = { TopBar("Сахар") }, backgroundColor = Color(0xFFF2FFF9)) {

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = " время",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "  сахар",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }



        LazyColumn(modifier = Modifier.fillMaxWidth().padding(top = 25.dp)) {
            items(allSugar.value) {sugar ->
                SugarCard(sugar.rate, sugar.time) { mvm.deleteSugar(sugar) }
            }
        }
    }
}